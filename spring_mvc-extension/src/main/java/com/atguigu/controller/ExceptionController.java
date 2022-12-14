package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-12 22:31
 * @Description:
 */

// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    // 设置我们要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    //ex表示控制器方法所出现的异常
    public String handleException(Throwable ex,Model model) {
        model.addAttribute("ex",ex);
        return "error";
    }
}