package com.ssm.test;

import com.ssm.dto.AppointExecution;
import com.ssm.entity.Book;
import com.ssm.service.impl.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by stm on 2018/4/1.
 */
public class BookServiceImpTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1011;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }

    @Test
    public void testGetById() throws Exception{
        long bookId=1001;

        Book book=bookService.getById(bookId);

        System.out.println(book);
    }


    @Test
    public void testGetList() throws  Exception{

        List<Book> list=bookService.getList();

        System.out.println(list);
    }
}