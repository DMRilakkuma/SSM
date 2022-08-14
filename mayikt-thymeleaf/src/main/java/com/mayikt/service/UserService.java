package com.mayikt.service;

import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/insertUser")
    public String insertUser(String userName, Integer age) {
        int update = jdbcTemplate.update("insert into users values (null,?,?)", userName, age);
        return update > 0 ? "success" : "fail";
    }


    @RequestMapping("/mybatisfindbyId")
    public UserEntity mybatisfindbyId(Integer id) {
        return userMapper.selectByUserId(id);
    }

    @RequestMapping("/insertUserMybatis")
    public String insertUserMybatis(String userName, Integer age) {
        int insert = userMapper.insertUser(userName, age);
        return insert > 0 ? "success" : "fail";
    }
}
