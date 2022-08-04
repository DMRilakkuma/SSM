package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-20 10:44
 * @Description:
 */

public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取sql的会话对象(不会自动提交事务)
//        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取sql的会话对象(会自动提交事务)
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取usermapper代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用mapper接口中的方法，来实现添加用户信息的功能

        // 提供sql以及的唯一标识找到sql并执行，唯一标识namspace.sqlId
//        int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");

        int result = mapper.insertUser();
        System.out.println("结果" + result);
        // 提交事务
        sqlSession.commit();
        // 关闭sqlSession对象
        sqlSession.close();

    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testdelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getAllUsers() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUsers = mapper.getAllUsers();
        for(User u : allUsers){
            System.out.println(u);
        }
        sqlSession.close();
    }

}