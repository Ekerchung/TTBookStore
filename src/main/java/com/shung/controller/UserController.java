package com.shung.controller;

import com.google.gson.Gson;
import com.shung.pojo.User;
import com.shung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: User的Controller，用來接受請求及響應瀏覽器
 * @author: Eker
 * @date: 2023/2/26 下午 01:51
 * @version: V1.0
 */

/*
 * 使用者登入 -->/user/login -->POST
 * 使用者登出 -->/user/1ogout -->GET
 * Ajax驗證用戶名稱是否可用 -->/to/user/checkUsername -->GET
 * 註冊功能 -->/user/regist -->POST
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

    /**
     * @titile: logout
     * @description: 用戶登出
     * @param model springMVC內建的傳參類
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/13 上午 11:46
     */

    @RequestMapping(value = "/user/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req,Model model){
        //銷毀session中的資料
        req.getSession().invalidate();
        //重定向回首頁
        return "redirect:/";
    }

    /**
     * @titile: checkUsername
     * @description: Ajax驗證用戶名稱是否可用
     * @param username 用戶名
     * @author: Eker
     * @date: 2023/3/13 上午 11:44
     */
    @RequestMapping(value = "/to/user/checkUsername",method = RequestMethod.GET)
    public void checkUsername(String username, HttpServletResponse resp) throws ServletException, IOException {
        //1. 調用userService.existUsername方法確認username是否存在
        boolean existUsername = userService.existUsername(username);
        //2. 將返回的結果封裝到Map對象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);
        //3. 將Map對象回傳給客戶端
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        System.out.println(json);
        resp.getWriter().write(json);

    }

    /**
     * @titile: regist
     * @description: 後台驗證註冊訊息並保存到資料庫
     * @param model springMVC內建的傳參類
     * @param user 作為保存註冊訊息的User類容器
     * @param checkpassword 確認輸入密碼
     * @return: String 請求轉發的分頁名
     * @author: Eker
     * @date: 2023/3/13 上午 11:47
     */
    @RequestMapping(value = "/user/regist",method = RequestMethod.POST)
    public String regist(Model model,User user,String checkpassword,HttpServletRequest req){
        //獲取驗證碼
        String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //刪除session中的驗證碼，避免重複提交
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        //獲取輸入的驗證碼
        String inputCode = (String) req.getParameter("code");
        //確認輸入資料是否非空
        if(user.getUsername() == null || user.getPassword() == null || user.getEmail() == null || checkpassword == null || inputCode == null ){
            model.addAttribute("errormsg","所有欄位不可為空!!");
            return "/pages/user/regist";
        }
        //確認驗證碼是否正確
        if(!inputCode.equals(token)){
            model.addAttribute("errormsg","驗證碼錯誤!!");
            return "/pages/user/regist";
        }
        //確認密碼確認是否正確
        if(!user.getPassword().equals(checkpassword)){
            model.addAttribute("errormsg","請確認密碼!!");
            return "/pages/user/regist";
        }
        //確認用戶名是否存在
        boolean exist = userService.existUsername(user.getUsername());
        String username = user.getUsername();
        if(exist){
            //若用戶名已存在，返回註冊頁
            model.addAttribute("errormsg","用戶名已存在!!");
            return "/pages/user/regist";
        }else if(!user.getUsername().matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$")){
            System.out.println(username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$"));
            //若用戶名不符合規定，返回註冊頁
            model.addAttribute("errormsg","用戶名不符合規定!!");
            return "/pages/user/regist";
        }else if(!user.getPassword().matches("^[a-zA-Z]\\w{5,17}$")){
            //若密碼不符合規定，返回註冊頁
            model.addAttribute("errormsg","密碼不符合規定!!");
            return "/pages/user/regist";
        }else if(!user.getEmail().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
            //若信箱不符合規定，返回註冊頁
            model.addAttribute("errormsg","信箱不合法!!");
            return "/pages/user/regist";
        }
            //調用userService.userRegist保存用戶註冊資訊
            userService.userRegist(user);
            return "/pages/user/registSuccess";

    }

}
