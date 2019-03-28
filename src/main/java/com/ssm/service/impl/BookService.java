package com.ssm.service.impl;


import com.ssm.dto.AppointExecution;
import com.ssm.entity.Book;

import java.util.List;

/**
 * Created by stm on 2018/3/17.
 */
public interface BookService {

    /**
     * 查询一本图书
     *
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> getList();

    /**
     * 预约图书
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);

}
