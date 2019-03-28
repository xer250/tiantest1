package com.ssm.test;

/**
 * Created by stm on 2018/3/18.
 */

import com.ssm.dao.BookDao;
import com.ssm.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;
    @Test
    public void testQueryById() throws Exception {
        long bookId = 1001;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

   /* @Test
    public void testQueryAll() throws Exception {
        List<Book> books = bookDao.queryAll(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update=" + update);
    }*/

   /* @Test
    public void testDelete() throws Exception{
        long bookId=1000;
        int delete=bookDao.deleteBook( bookId);
        System.out.println("delete=" + delete);
    }*/
    @Test
    public void testInsert() throws  Exception{
        long bookId=1119;
        String name="ddd";
        int   number=100;
        int insert=bookDao.insertBook(bookId, name,number);

        System.out.println("insert=" + insert);

    }

   /* @Test
    public void testInsertBook() throws Exception {
        long bookId =1000;
       int number = 12;
       String name="操作系统";
        int insert1 = bookDao.insertBook( bookId, name, number);
        System.out.println("insert=" + insert1);
    }*/




}
