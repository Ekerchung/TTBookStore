package com.shung.service;

import com.github.pagehelper.PageInfo;
import com.shung.pojo.Book;
import com.shung.pojo.Cart;
import com.shung.pojo.Order;

import com.shung.pojo.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: Order類的事物處理
 * @author: Eker
 * @date: 2023/3/9 下午 06:48
 * @version: V1.0
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);

    PageInfo<Order> showMyOrder(Integer pageNum, Integer userId);

    List<OrderItem> showOrderDetail(String orderId);

    void receiveOrder(String orderId);

    void deliverOrder(String orderId);

    PageInfo<Order> showAOrder(Integer pageNum);
}
