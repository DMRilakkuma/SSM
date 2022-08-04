package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-29 20:18
 * @Description:
 */

public class UserController{

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }



}