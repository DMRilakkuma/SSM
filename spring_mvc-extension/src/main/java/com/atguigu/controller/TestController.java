package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-12 20:33
 * @Description:
 */

@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello() {
        System.out.println(1/0);
        return "success";
    }

}