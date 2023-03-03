package com.shung.controller;

import com.shung.pojo.User;
import com.shung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.PrivateKey;
import java.util.List;

/**
 * @Description: User的Controller，用來接受請求及響應瀏覽器
 * @author: Eker
 * @date: 2023/2/26 下午 01:51
 * @version: V1.0
 */

/*
 * 使用者登入 -->/user/login -->post
 * 使用者登出 -->/user/1ogout -->put
 * 註冊功能 -->/user -->post
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login" ,method = RequestMethod.POST)
    public String login(Model model, User user, HttpServletRequest req, HttpSession session){
        //獲取驗證碼
        String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //刪除session中的驗證碼，避免重複提交
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        //獲取輸入的驗證碼
        String inputCode = (String) req.getParameter("code");
        //調用子類UserServiceImp中的userlogin()，確認登入帳號密碼是否正確
        User login = userService.userlogin(user);
        //判斷登入信息是否正確
        if(login == null || "".equals(user.getUsername())){
            model.addAttribute("errormsg","用戶名或密碼錯誤!!");
            model.addAttribute("username",user.getUsername());
            return "/pages/user/login";

        }else if(token == null || !token.equals(inputCode)){
            model.addAttribute("errormsg","驗證碼錯誤!!");
            model.addAttribute("username",user.getUsername());
            return "/pages/user/login";
        }else{
            session.setAttribute("login",login);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req,Model model){
        //銷毀session中的資料
        req.getSession().invalidate();
        //重定向回首頁
        return "redirect:/";
    }
}
