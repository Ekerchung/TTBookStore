package com.shung.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shung.mapper.BookMapper;
import com.shung.pojo.Book;
import com.shung.pojo.BookExample;
import com.shung.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: BookService的實現類
 * @author: Eker
 * @date: 2023/3/1 上午 11:32
 * @version: V1.0
 */
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfo<Book> getBookListBySort(Integer pageNum, Integer minPrice, Integer maxPrice) {
//        開啟分頁功能
        PageHelper.startPage(pageNum,4);
//        查詢所有圖書信息
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBPriceBetween(new BigDecimal(minPrice),new BigDecimal(maxPrice));
        List<Book> books = bookMapper.selectByExample(bookExample);
//        獲取分頁信息
        PageInfo<Book> page = new PageInfo<>(books,5);
//        返回分頁信息
        return page;
    }

    @Override
    public PageInfo<Book> getBookList(Integer pageNum) {
//        開啟分頁功能
        PageHelper.startPage(pageNum,4);
//        查詢所有圖書信息
        List<Book> books = bookMapper.selectByExample(null);
//        獲取分頁信息
        PageInfo<Book> page = new PageInfo<>(books,5);
//        返回分頁信息
        return page;
    }

    @Override
    public void deleteBookById(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Book queryBookById(Integer bId) {
        Book book = bookMapper.selectByPrimaryKey(bId);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        //調用bookMapper.updateByPrimaryKeySelective(book)更新圖書信息

        bookMapper.updateByPrimaryKeySelective(book);
    }
}
