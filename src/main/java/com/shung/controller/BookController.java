package com.shung.controller;

import com.github.pagehelper.PageInfo;
import com.shung.pojo.Book;
import com.shung.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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

    /**
     * @titile: toIndexpage
     * @description: 首頁的圖書分頁信息
     * @param model springMVC內建的傳參類
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 上午 12:06
     */
    @RequestMapping(value ="/",method = RequestMethod.GET)
    public String toIndexpage(Model model){
        //默認首頁為圖書分頁的第一頁
        Integer pageNum = 1;
        //調用bookService.getBookList()獲取圖書分頁信息
        PageInfo<Book> page = bookService.getBookList(pageNum);
        //設置分頁url
        String mappingUrl = "/book/page/";
        //將分頁信息保存到請求域中
        model.addAttribute("page",page);
        //將分頁url保存到請求域中
        model.addAttribute("mappingUrl",mappingUrl);
        return "index";
    }
//    @RequestMapping(value ="/book",method = RequestMethod.GET)
//    public String queryBooks(Model model){
//        Integer pageNum = 1;
//        PageInfo<Book> page = bookService.getBookList(pageNum);
//        model.addAttribute("page",page);
//        return "/pages/manager/book_manager";
//    }

    /**
     * @titile: queryBooks
     * @description: 圖書的分頁信息
     * @param model springMVC內建的傳參類
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 上午 12:02
     */
    @RequestMapping(value ="/book/page/{pageNum}",method = RequestMethod.GET)
    public String queryBooks(Model model, @PathVariable("pageNum") Integer pageNum){
        //調用bookService.getBookList()獲取圖書分頁信息
        PageInfo<Book> page = bookService.getBookList(pageNum);
        //設置分頁url
        String mappingUrl = "/book/page/";
        //將分頁信息保存到請求域中
        model.addAttribute("page",page);
        //將分頁url保存到請求域中
        model.addAttribute("mappingUrl",mappingUrl);
        return "index";
    }

    /**
     * @titile: queryBooksForManager
     * @description: 管理圖書的分頁信息
     * @param model springMVC內建的傳參類
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 上午 12:07
     */
    @RequestMapping(value ="/book/manager/page/{pageNum}",method = RequestMethod.GET)
    public String queryBooksForManager(Model model, @PathVariable("pageNum") Integer pageNum){
        //調用bookService.getBookList()獲取圖書分頁信息
        PageInfo<Book> page = bookService.getBookList(pageNum);
        //設置分頁url
        String mappingUrl = "/book/manager/page/";
        //將分頁信息保存到請求域中
        model.addAttribute("page",page);
        //將分頁url保存到請求域中
        model.addAttribute("mappingUrl",mappingUrl);
        return "/pages/manager/book_manager";
    }

    /**
     * @titile: queryBooksBySort
     * @description: 依據價格範圍查詢圖書分頁信息
     * @param model springMVC內建的傳參類
     * @param pageNum 分頁頁碼
     * @param minPrice 價格範圍下限
     * @param maxPrice 價格範圍上限
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 上午 12:08
     */
    @RequestMapping(value = "/book/page/search/{pageNum}",method = RequestMethod.GET)
    public String queryBooksBySort(Model model, @PathVariable("pageNum") Integer pageNum, Integer minPrice, Integer maxPrice){
        //若未輸入查詢範圍下限，將下限值設為0
        if(minPrice == null){
            minPrice = 0;
        }
        //若未輸入查詢範圍上限，將下限值設為Integer的最大值
        if(maxPrice == null){
            maxPrice = Integer.MAX_VALUE;
        }
        //調用bookService.getBookListBySort()獲取圖書分頁信息
        PageInfo<Book> page = bookService.getBookListBySort(pageNum,minPrice,maxPrice);
        //將分頁信息保存到請求域中
        model.addAttribute("page",page);
        //將minPrice和maxPrice回顯到頁面
        if(minPrice != 0){
            model.addAttribute("minPrice",minPrice);
        }
        if(maxPrice != Integer.MAX_VALUE){
            model.addAttribute("maxPrice",maxPrice);
        }
        return "index";
    }

    /**
     * @titile: deleteBook
     * @description: 刪除圖書信息
     * @param bId 圖書id
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 下午 04:45
     */
    @RequestMapping(value = "/book/{bId}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bId") Integer bId, Integer pageNum){
        //調用bookService.deleteBookById(bId)刪除圖書
        bookService.deleteBookById(bId);
        //調用bookService.getBookList()獲取圖書分頁信息
        PageInfo<Book> page = bookService.getBookList(pageNum);
        //獲取總分頁數
        int pages = page.getPages();
        //若分頁大於總分頁，返回最後一頁
        if(pageNum > pages){
            pageNum = pages;
        }
        return "redirect:/book/manager/page/" + pageNum;
    }

    /**
     * @titile: queryBookById
     * @description: 根據id查詢圖書信息
     * @param bId 圖書id
     * @param model springMVC內建的傳參類
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 下午 04:43
     */
    @RequestMapping(value = "/book/{bId}/{pageNum}",method = RequestMethod.GET)
    public String queryBookById(@PathVariable("bId") Integer bId,Model model, @PathVariable("pageNum") Integer pageNum){
        //調用bookService.queryBookById(bId)查詢圖書信息
        Book book = bookService.queryBookById(bId);
        //保存圖書信息到請求域中
        model.addAttribute("book",book);
        //保存來源頁碼到請求域中
        model.addAttribute("pageNum",pageNum);
        //請求轉發到修改頁面
        return "pages/manager/book_edit";
    }

    /**
     * @titile: updateBook
     * @description: 更新圖書信息
     * @param book 自動裝配表格的圖書信息容器
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/7 下午 04:46
     */
    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public String updateBook(Model model,Book book, Integer pageNum){
        //調用bookService.updateBook(book)更新圖書信息
        bookService.updateBook(book);
        //返回原管理頁面
        return "redirect:/book/manager/page/" + pageNum;
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(Book book){
        //調用bookService.addBook(book)新增圖書
        bookService.addBook(book);
        //返回管理頁面
        return "redirect:/book/manager/page/1";
    }
}
