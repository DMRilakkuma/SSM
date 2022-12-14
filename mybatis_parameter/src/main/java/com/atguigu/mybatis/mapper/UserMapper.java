package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

//mybatis 获取参数数值的两个方式:#{}和${}
// #{}的本质是占位符的赋值,${}的本质是字符串拼接
// 1 . 诺mapper接口方法的参数为单个的字面量类型
// 此时可以通过#{}和${}以任意内容获取参数值，一定要注意${}的单引号问题

//2，诺mapper接口方法的参数为多个的字面量类型
// 此时mybatis会将参数放在map集合中,任何以两种方式存储数据
// 以arg0，arg1.... 为键,以参数为值1
// 以parm1,parm2...为键,以参数为值
// 因此，只需要通过#{}和${}访问map集合的键，就可以获得相对应的值

//3.诺mapper接口的参数为map集合的类型的参数
// 只需要通过#{}和${}访问map集合的键，就可以获得相对应的值，一定要注意${}的单引号问题

// 4.诺mapper接口的方法的参数为实体类类型的参数
// 只需要通过#{}和${}访问实体类中的属性名,就可以获取相对应的属性值,一定要注意${}的单引号问题

// 5.可以在mapper接口方法的参数上设置@param注解
// 此时mybatis会将这些参数放在map中，以两种方式进行储存
// a>以@param注解的value属性值为键，以参数为值
// a>以parm1,parm2...为键,以参数为值

public interface UserMapper {

    /*根据用户名查询用户信息*/
    User getUserByUsername(String username);

    /*验证登录*/
    User checkLogin(String username, String password);


    User checkLoginByMap(Map<String,Object> map);

    /*添加用户信息的功能*/
    void insertUser(User user);

    /*验证登录(使用@parm注解)*/
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
