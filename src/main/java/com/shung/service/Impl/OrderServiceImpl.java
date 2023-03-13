package com.shung.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shung.mapper.BookMapper;
import com.shung.mapper.OrderItemMapper;
import com.shung.mapper.OrderMapper;
import com.shung.pojo.*;
import com.shung.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: OrderService的實現類
 * @author: Eker
 * @date: 2023/3/9 下午 06:49
 * @version: V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //1. 保存訂單對象order到數據庫
        //1.1將cart對象轉為order對象
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        System.out.println(order);
        //1.2調用saveOrder方法保存訂單
        orderMapper.insertSelective(order);

        //2. 保存訂單項對象orderItem到數據庫
        //遍歷購物車的購物項對象cartItem，並將購物項內容保存至訂單項orderItem對象中
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            //將購物項內容轉化到訂單項orderItem對象
            OrderItem orderItem = new OrderItem(null,orderId,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), cartItem.getImgPath());
            //保存orderItem對象至數據庫
            orderItemMapper.insertSelective(orderItem);
            //更新商品庫存信息
            Book book = bookMapper.selectByPrimaryKey(cartItem.getId());
            book.setbSales(book.getbSales() + cartItem.getCount());
            book.setbStoke(book.getbStoke() - cartItem.getCount());
            bookMapper.updateByPrimaryKeySelective(book);
        }

        //清空購物車
        cart.clear();
        //返回訂單id
        return orderId;

    }

    @Override
    public PageInfo<Order> showMyOrder(Integer pageNum, Integer userId) {
        //        開啟分頁功能
        PageHelper.startPage(pageNum,4);
        //依用戶id查詢訂單
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUIdEqualTo(userId);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        //獲取分頁信息
        PageInfo<Order> page = new PageInfo<>(orders,5);
        return page;
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        OrderItemExample orderItemExample = new OrderItemExample();
        orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
        return orderItems;
    }

    @Override
    public void receiveOrder(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setStatus(2);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void deliverOrder(String orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setStatus(1);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public PageInfo<Order> showAOrder(Integer pageNum) {
        //        開啟分頁功能
        PageHelper.startPage(pageNum,4);
        //查詢全部訂單
        List<Order> orders = orderMapper.selectByExample(null);
        //獲取分頁信息
        PageInfo<Order> page = new PageInfo<>(orders,5);
        return page;
    }
}
