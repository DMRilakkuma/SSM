package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-30 16:12
 * @Description:
 */

@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}