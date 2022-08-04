package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-30 16:13
 * @Description:
 */

public class IOCByAnnotationTest {


    /*
    * @Component:将类标识为普通组件
    * @Controller:将类标识为控制层组件
    * @Service:将类标识为业务层组件
    * @Repository:将类标识为持久层组件
    *
    * 通过注解+扫描所配置的bean的id，默认值为小驼峰，即类名为首字母为小写的结果
    * 可以通过标识组件的注解value属性值设置bean的自定义id
    *
    * @Autowired:自动装配，通过类型或者名称进行装配
    * a>表示在成员变量上,此时不需要设置成员变量的set方法
    *b>标识在set方法上
    * c>为当前成员变量赋值的有参构造上
    *
    * 2.@Autowired注解的原理
    * a>默认通过byType的方式，在IOC容器中类型匹配某个bean为属性赋值
    * b>诺有多个类型匹配的bean,此时会自动转换为byName方式实现自动装配
    * 即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
    * c>诺byType和byName的方式无法实现自动装配，即IOC容器中有多个类型匹配的bean，
    * 且这些bean的id和要赋值的属性的属性名都不一致，此时会抛出异常：NoUniqueBeanDefinitionException
    * d>此时可以在要赋值的属性上，添加一个注解@Qualifier
    * 通过该注解的valu的属性值，通过某个bean的id,来指定要赋值的属性的属性名
    *
    * 注意:诺  ioc类型中没有任何一个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
    * 在@Autowired注解中有个属性required，默认值为true,要求必须完成自动装配
    * 可以将required设置为false，表示如果ioc容器中没有类型匹配的bean，则不进行自动装配
    * */

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        /*System.out.println(userController);
        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userDao);*/
        userController.saveUser();
    }
}