package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-30 16:18
 * @Description:
 */

//@Controller("controller")
@Controller
public class UserController {

    @Autowired
    // @Qualifier("userServiceImpl")
    private UserService userService;


   /* public UserController(UserService userService) {
        this.userService = userService;
    }*/


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }

}