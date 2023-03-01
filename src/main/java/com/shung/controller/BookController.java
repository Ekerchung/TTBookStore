package com.shung.controller;

import com.github.pagehelper.PageInfo;
import com.shung.pojo.Book;
import com.shung.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: Book的Controller，用來接受請求及響應瀏覽器
 * @author: Eker
 * @date: 2023/2/26 下午 01:55
 * @version: V1.0
 *
 */


/*
 * 查詢所有的圖書信息 -->/book -->get
 * 查詢自訂價格範圍的圖書信息 -->/book/1 -->get
 * 查詢圖書的分頁信息 -->/book/page/1 -->get
 * 查詢自訂價格範圍的圖書分頁信息 -->/book/page/1/2/3 -->get
 * 根據id查詢圖書信息 -->/book/1 -->get
 * 跳轉到添加頁面 -->/to/add -->get
 * 添加圖書信息 -->/book -->post
 * 修改圖書信息 -->/book -->put
 * 刪除圖書信息 -->/book -->delete
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value ="/",method = RequestMethod.GET)
    public String toIndexpage(Model model){
        Integer pageNum = 1;
        PageInfo<Book> page = bookService.getBookList(pageNum);
        model.addAttribute("page",page);
        return "index";
    }
    @RequestMapping(value ="/book/page/{pageNum}",method = RequestMethod.GET)
    public String queryBooks(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Book> page = bookService.getBookList(pageNum);
        model.addAttribute("page",page);
        return "index";
    }
    @RequestMapping(value = "/book/page/search/{pageNum}",method = RequestMethod.GET)
    public String queryBooksBySort(Model model, @PathVariable("pageNum") Integer pageNum, Integer minPrice, Integer maxPrice){
        if(minPrice == null){
            minPrice = 0;
        }
        if(maxPrice == null){
            maxPrice = Integer.MAX_VALUE;
        }
        PageInfo<Book> page = bookService.getBookListBySort(pageNum,minPrice,maxPrice);
        model.addAttribute("page",page);
        if(minPrice != 0){
            model.addAttribute("minPrice",minPrice);
        }
        if(maxPrice != Integer.MAX_VALUE){
            model.addAttribute("maxPrice",maxPrice);
        }
        return "index";
    }


}
