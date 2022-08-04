package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-29 20:19
 * @Description:
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}