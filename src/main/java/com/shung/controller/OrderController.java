package com.shung.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.shung.pojo.*;
import com.shung.service.BookService;
import com.shung.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.Transient;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: Order的Controller，用來接受請求及響應瀏覽器
 * @author: Eker
 * @date: 2023/2/26 下午 01:56
 * @version: V1.0
 */

/*
 * 創建訂單 -->/to/order/add -->GET
 * 顯示使用者的訂單 -->/order/page/{pageNum} -->GET
 * 顯示全部訂單 -->/order/manager/page/{pageNum} -->GET
 * 顯示訂單詳情 -->/order/{orderId}/{orderPrice} -->GET
 * 收貨 -->/order/receive/{orderId} -->GET
 * 發貨 -->/order/deliver/{orderId} -->
 *
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * @titile: createOrder
     * @description: 創建訂單，並保存訂單及訂單項內容到資料庫
     * @return: String 重定向的分頁名
     * @author: Eker
     * @date: 2023/3/13 上午 11:52
     */
    @Transactional
    @RequestMapping(value = "/to/order/add", method = RequestMethod.GET)
    protected String createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //獲取session中的user及cart參數
        User user = (User) req.getSession().getAttribute("login");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //若使用者未登入，則導到登入頁面
        if(user == null){
            return "pages/user/login";
        }
        //獲取使用者id
        Integer userId = user.getuId();
        //使用createOrder方法，創建order訂單，並返回訂單編號
        String orderId = orderService.createOrder(cart, userId);
        //保存訂單編號到session域中
        req.getSession().setAttribute("orderId",orderId);
        //使用重定向導至動單完成頁面，避免重複提交
        return "redirect:/to/cart/checkout";
    }

    /**
     * @titile: showMyOrder
     * @description: 顯示使用者的訂單
     * @param model springMVC內建的傳參類
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/13 上午 11:54
     */
    @RequestMapping(value = "/order/page/{pageNum}", method = RequestMethod.GET)
    protected String showMyOrder(HttpSession session, Model model, @PathVariable("pageNum") Integer pageNum) throws ServletException, IOException {
        //獲取用戶訊息
        User user = (User)session.getAttribute("login");
        //獲取用戶id
        Integer uId = user.getuId();
        //使用showMyOrder方法，取得使用者的訂單
        PageInfo<Order> page = orderService.showMyOrder(pageNum,uId);
        //設置分頁url
        String mappingUrl = "/order/page/";
        //將分頁信息保存到請求域中
        model.addAttribute("page",page);
        //將分頁url保存到請求域中
        model.addAttribute("mappingUrl",mappingUrl);
        //請求轉發至myorderlist頁面顯示內容
        return "/pages/order/myorderlist";
    }

    /**
     * @titile: showAllOrder
     * @description: 顯示全部訂單
     * @param model springMVC內建的傳參類
     * @param pageNum 分頁頁碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/13 上午 11:58
     */
    @RequestMapping(value = "/order/manager/page/{pageNum}", method = RequestMethod.GET)
    protected String showAllOrder(HttpSession session, Model model, @PathVariable("pageNum") Integer pageNum) throws ServletException, IOException {
        //使用showAOrder方法，取得使用者的訂單
        PageInfo<Order> page = orderService.showAOrder(pageNum);
        //設置分頁url
        String mappingUrl = "/order/manager/page/";
        //將分頁信息保存到請求域中
        model.addAttribute("page",page);
        //將分頁url保存到請求域中
        model.addAttribute("mappingUrl",mappingUrl);
        //請求轉發至orderlist頁面顯示內容
        return "/pages/manager/orderlist";
    }

    /**
     * @titile: showOrderDetail
     * @description: 顯示訂單詳情
     * @param model springMVC內建的傳參類
     * @param orderId 訂單編號
     * @param orderPrice 訂單總價格
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/13 下午 12:01
     */
    @RequestMapping(value = "/order/{orderId}/{orderPrice}",method = RequestMethod.GET)
    protected String showOrderDetail(Model model, @PathVariable("orderId") String orderId, @PathVariable("orderPrice") String orderPrice){
        //使用showOrderDetail方法獲取訂單項內容
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        //將訂單項內容保存至request域中
        model.addAttribute("orderItems",orderItems);
        //將訂單編號保存至request域中
        model.addAttribute("orderId",orderId);
        //將訂單總金額保存至request域中
        model.addAttribute("orderPrice",orderPrice);
        //請求轉發至orderDetail頁面顯示數據
        return "/pages/order/orderDetail";

    }

    /**
     * @titile: receiveOrder
     * @description: 收貨
     * @param orderId 訂單編號
     * @return: String 重定向的分頁名
     * @author: Eker
     * @date: 2023/3/13 下午 12:03
     */
    @RequestMapping(value = "/order/receive/{orderId}", method = RequestMethod.GET)
    protected String receiveOrder(HttpServletRequest req, @PathVariable("orderId") String orderId){
        //使用 orderService.receiveOrder(orderId);方法，更新訂單狀態
        orderService.receiveOrder(orderId);
        //重定向回頁面
        return "redirect:" + req.getHeader("Referer");

    }

    /**
     * @titile: deliverOrder
     * @description: 發貨
     * @param orderId 訂單編號
     * @return: String 重定向的分頁名
     * @author: Eker
     * @date: 2023/3/13 下午 12:05
     */
    @RequestMapping(value = "/order/deliver/{orderId}", method = RequestMethod.GET)
    protected String deliverOrder(HttpServletRequest req, @PathVariable("orderId") String orderId){
        //使用 orderService.deliverOrder(orderId);方法，更新訂單狀態
        orderService.deliverOrder(orderId);
        //重定向回頁面
        return "redirect:" + req.getHeader("Referer");

    }
}
