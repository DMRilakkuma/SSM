package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    /*
     * 通过用户名模糊查询用户信息*/
    List<User> getUserByLike(@Param("mohu") String mohu);

    void deleteMoreUser(@Param("ids") String ids);

    List<User> getUserList(@Param("tableName") String tableName);

    /*添加用户信息，来获取自增的主键*/
    void insertUser(User user);
}
