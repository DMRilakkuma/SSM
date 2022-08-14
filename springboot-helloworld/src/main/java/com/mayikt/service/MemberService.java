package com.mayikt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-14 21:18
 * @Description:
 */

@RestController
public class MemberService {
    @Value("mayikt.name")
    private String name;
    @Value("mayikt.age")
    private String age;

    @RequestMapping("/getMember")
    public String getMember() {
        return "每特教育";
    }

    @RequestMapping("/getProperties")
    public String getProperties() {
        return name + "--" + age;
    }
}