package com.shung.controller;

import com.google.gson.Gson;
import com.shung.pojo.Book;
import com.shung.pojo.Cart;
import com.shung.pojo.CartItem;
import com.shung.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Order的Controller，用來接受請求及響應瀏覽器
 * @author: Eker
 * @date: 2023/2/26 下午 01:56
 * @version: V1.0
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
public class OrderController {

}
