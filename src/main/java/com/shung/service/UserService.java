package com.shung.service;

import com.shung.mapper.UserMapper;
import com.shung.pojo.User;

import java.util.List;

/**
 * @Description: User類的事物處理接口
 * @author: Eker
 * @date: 2023/3/2 下午 04:23
 * @version: V1.0
 */
public interface UserService {
    User userlogin(User user);
}
