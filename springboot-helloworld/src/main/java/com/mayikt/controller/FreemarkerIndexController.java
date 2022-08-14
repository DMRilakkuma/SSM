package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-14 21:58
 * @Description:
 */

@Controller
public class FreemarkerIndexController {
    @RequestMapping("/freemarkIndex")
    public String freemarkerIndex(Map<String, Object> result, HttpServletRequest request) {
        result.put("name", "mayikt");
        result.put("sex", "0");
        result.put("age", 22);
        ArrayList<String> userList = new ArrayList<>();
        userList.add("mayikt");
        userList.add("xiaowei");
        result.put("userList",userList);
        return "freemarkIndex";
    }
}