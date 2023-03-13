package com.shung.controller;

import com.google.gson.Gson;
import com.shung.pojo.Book;
import com.shung.pojo.Cart;
import com.shung.pojo.CartItem;
import com.shung.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

    //ajax添加商品到購物車 --> '/**/cart/add -->GET
/*
 * 新增購物車 -->/to/cart -->GET
 * 修改購物車內購物車商品項之數量 -->to/cart/update -->GET
 * 清空購物車 -->/cart/clear -->GET
 * 刪除購物車中之購物車商品項 -->/cart/delete/{id} -->GET
 *
 */


/**
 * @Description: Cart的Controller，用來接受請求及響應瀏覽器
 * @author: Eker
 * @date: 2023/2/26 下午 01:56
 * @version: V1.0
 */
@Controller
public class CartController {
    @Autowired
    private BookService bookService;

    /**
     * @titile: addToCart
     * @description:  ajax的添加商品項至購物車
     * @param bId 添加到購物車的圖書商品id
     * @return: null
     * @author: Eker
     * @date: 2023/3/9 下午 02:25
     */
    @RequestMapping(value = "/**/cart/add", method = RequestMethod.GET)
    public void addToCart(Integer bId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //由商品編號查詢圖書訊息
        Book book = bookService.queryBookById(bId);
        //將圖書訊息封裝到CartItem中
        CartItem cartItem = new CartItem(book.getbId(),book.getbName(),book.getbPrice(),book.getbPrice(),1,book.getbImgpath());
        //調用cart.addItem方法添加商品項
        //先取得session域中的cart對象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //若session域中沒有購物車對象，則創建新的cart對象，並將此對象保存至session域中
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //將cartItem數量返回保存至Map
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        //Map內容返回至客戶端
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);

    }
    
    /**
     * @titile: addCart
     * @description: 檢查session中是否有購物車，若沒有則新增購物車
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/9 下午 02:27
     */
    @RequestMapping(value = "/to/cart", method = RequestMethod.GET)
    public String addCart(HttpServletRequest req){
        //先取得session域中的cart對象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //若session域中沒有購物車對象，則創建新的cart對象，並將此對象保存至session域中
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        return "pages/cart/cart";
    }

    /**
     * @titile: updateCount
     * @description: 修改購物車內購物車商品項之數量
     * @param bId 修改的圖書商品id
     * @param count 修改後的圖書商品數量
     * @return: String 重定向的分頁名
     * @author: Eker
     * @date: 2023/3/9 下午 02:29
     */
    @RequestMapping(value = "to/cart/update",method = RequestMethod.GET)
    protected String updateCount(Integer bId,Integer count,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先取得session域中的cart對象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //若session域中有購物車對象，則修改商品數量
        if(cart != null){
            //使用cart.updateCount方法修改商品數量
            cart.updateCount(bId,count);
        }
        //重定向回原購物車商品地址
        return "redirect:" + req.getHeader("Referer");
    }

    /**
     * @titile: clear
     * @description: 清空購物車
     * @return: String 重定向的分頁名
     * @author: Eker
     * @date: 2023/3/9 下午 02:30
     */
    @RequestMapping(value = "/cart/clear",method = RequestMethod.GET)
    protected String clear(HttpServletRequest req) throws ServletException, IOException {
        //先取得session域中的cart對象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //調用cart.clear()方法清空購物車
        cart.clear();
        //重定向回原購物車商品地址
        return "redirect:" + req.getHeader("Referer");
    }

    /**
     * @titile: deleteItem
     * @description: 刪除購物車中之購物車商品項
     * @param id 購物車中的商品項id
     * @return: String 重定向的分頁名
     * @author: Eker
     * @date: 2023/3/9 下午 02:31
     */
    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.GET)
    protected String deleteItem(HttpServletRequest req,@PathVariable("id") Integer id){
        //先取得session域中的cart對象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //調用cart.addItem方法添加商品項
        cart.deleteItem(id);
        //重定向回原購物車商品地址
        return "redirect:" + req.getHeader("Referer");
    }

}
