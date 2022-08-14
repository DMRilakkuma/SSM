package com.atguigu.controller;

import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-13 16:50
 * @Description:
 */

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
}