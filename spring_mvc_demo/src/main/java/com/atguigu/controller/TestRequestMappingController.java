package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-06 14:12
 * @Description: 1.RequestMapping注解标识的位置
 * RequestMapping标识一个类:设置映射请求的请求路径的初始信息
 * RequestMapping：标识一个方法，设置映射请求路径的具体信息
 * <p>
 * 2.@RequestMapping注解value属性
 * 作用:通过请求的请求路径匹配请求
 * value属性是数组类型,即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值,
 * 则当前请求就会被注解所标识的方法进行处理
 * <p>
 * 3.@RequestMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method属性中的任何一个
 * 诺浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配,但是请求方式不匹配
 * 此时页面报错：405 -Request method 'xxx' not supported
 * 在RequestMapping的基础上,结合请求方式的一些派生注解
 * @GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 *
 *4.RequestMapping注解的parms属性
 * 作用:通过请求的请求参数匹配请求，即浏览器发送的请求参数必须满足parms属性到的设置
 * parms可以使用四种表达式:
 * “parms” :表示当前请求的请求参数中必须携带param参数
 * “!parms”：表示当前请求的请求参数中一定不能携带param参数
 * “parms = value”：表示当前请求的请求参数中必须携带param参数且值必须为value
 * “parms != value”:表示当前请求的请求参数中必须不携带param参数且值，但是携带值一定不能为value
 *诺浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配,但是请求参数不匹配
 *则报错HTTP Status 400 - Parameter conditions "username, !password, age=20, gender!=女" not met for actual
 *  request parameters: username={admin}, age={20}, gender={女}
 *  5.@RequestMapping注解的headers属性
 *  作用：通过请求的请求头信息匹配请求,即浏览器发送的请求的请求信息必须满足headers属性到的设置
 *  诺浏览器所发送的请求的请求路径和@RequestMapping注解value属性匹配,但是请求参数不匹配
 *
 */

@Controller
// @RequestMapping("/test")
public class TestRequestMappingController {

    // 此时控制器方法匹配的请求的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            // params = {"username","!password","age=20","gender!=女"}
            headers = {"referer"}
    )
    public String hello() {
        return "success";
    }
}