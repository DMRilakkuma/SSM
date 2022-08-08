package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-08 15:04
 * @Description:
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";

    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = true, defaultValue = "hello") String name,
            String password,
            @RequestHeader(value = "referer", required = false) String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ) {
        System.out.println("name:" + name + ",password" + password + ",referer:," + referer + "jsessionId:" + jsessionId);
        return "success";
    }


    @RequestMapping("/param/pojo")
    public String getParameByPojo(User user) {
        System.out.println(user);
        return "success";
    }
}