package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-05 20:36
 * @Description:
 */

@Controller
public class HelloController {

    @RequestMapping("/")
    public String protal() {
        // 将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }
}