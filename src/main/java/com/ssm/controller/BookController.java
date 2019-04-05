package com.ssm.controller;

import com.ssm.dto.AppointExecution;
import com.ssm.dto.Result;
import com.ssm.entity.Book;
import com.ssm.enums.AppointStateEnum;
import com.ssm.exception.NoNumberException;
import com.ssm.exception.RepeatAppointException;
import com.ssm.service.impl.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by stm on 2018/3/17.
 */

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;



    @RequestMapping(value="/test")
    public ModelAndView test(){
        ModelAndView mav=new ModelAndView("/test");
        /*mav.addObject("time", new Date());
        mav.getModel().put("name", "caoyc");*/

        return mav;
         }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String booklist(Model model) {
        List<Book> blist = bookService.getList();
        model.addAttribute("blist", blist);
        // list.jsp + model = ModelAndView
        return "list";
    }

    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    // ajax json
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
        if (studentId == null || studentId.equals("")) {
            return new Result(false, "学号不能为空");
        }
        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, execution);
    }

}