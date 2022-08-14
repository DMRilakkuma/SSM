package com.mayikt.controller;

import com.mayikt.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-14 22:59
 * @Description:
 */

@Controller
public class MyThymeleafController {

    @RequestMapping("/myThymeleaf")
    public String myThymeleaf(HttpServletRequest request, Map<String, Object> result) {
        result.put("user", new UserEntity("mayikt", 22,1));
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("mayikt1", 22,2));
        userEntities.add(new UserEntity("mayikt2", 22,3));
        userEntities.add(new UserEntity("mayikt3", 22,4));
        result.put("userList", userEntities);
        return "myThymeleaf";
    }
}