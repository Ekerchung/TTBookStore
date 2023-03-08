package com.shung.service;

import com.github.pagehelper.PageInfo;
import com.shung.pojo.Book;

/**
 * @Description: book類的事物處理接口
 * @author: Eker
 * @date: 2023/3/3 上午 10:42
 * @version: V1.0
 */
public interface BookService {
    PageInfo<Book> getBookList(Integer pageNum);

    PageInfo<Book> getBookListBySort(Integer pageNum, Integer minPrice, Integer maxPrice);

    void deleteBookById(Integer id);

    Book queryBookById(Integer bId);

    void updateBook(Book book);
}
