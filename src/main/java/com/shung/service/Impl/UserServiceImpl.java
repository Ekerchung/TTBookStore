package com.shung.service.Impl;

import com.shung.mapper.UserMapper;
import com.shung.pojo.User;
import com.shung.pojo.UserExample;
import com.shung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: UserService的實現類
 * @author: Eker
 * @date: 2023/3/2 下午 04:24
 * @version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User userlogin(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(!users.isEmpty()){
            User login = users.get(0);
            return login;
        }
        return null;
    }
}
