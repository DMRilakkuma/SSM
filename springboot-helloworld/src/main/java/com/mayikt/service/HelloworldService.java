package com.mayikt.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-14 21:01
 * @Description:
 */

@RestController
/*@EnableAutoConfiguration
@ComponentScan("com.mayikt.service")*/
public class HelloworldService {

    @RequestMapping("/getUser")
    public String getUser() {
        return "mayikt";
    }

    /*public static void main(String[] args) {
        // 启动类入口class，默认整合Tomcat容器
        SpringApplication.run(HelloworldService.class,args);
    }*/

}