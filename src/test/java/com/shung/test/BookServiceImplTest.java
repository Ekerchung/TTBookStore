package com.shung.test;

import com.github.pagehelper.PageInfo;
import com.shung.pojo.Book;
import com.shung.service.BookService;
import com.shung.service.Impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @Description:
 * @author: Eker
 * @date: 2023/3/1 下午 02:06
 * @version: V1.0
 */
public class BookServiceImplTest{
    BookService bookService = new BookServiceImpl();

    @Test
    public void testGetBookListBySort() {
        PageInfo<Book> bookListBySort = bookService.getBookListBySort(1, 0, 50);
        System.out.println(bookListBySort);
    }

    @Test
    public void testGetBookList() {
        PageInfo<Book> bookList = bookService.getBookList(1);
        System.out.println(bookList);
    }
}