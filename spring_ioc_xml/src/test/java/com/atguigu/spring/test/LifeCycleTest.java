package com.atguigu.spring.test;

import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-29 19:30
 * @Description:
 */

public class LifeCycleTest {

    /*
    * 1.实列化
    * 2.依赖注入
    * 3.后置处理器的postProcessBeforeInitialization
    * 4.初始化,需要通过bean的init——method属性指定初始化方法
    * 5.后置处理器的postProcessAfterInitialization
    * 6.IOC容器关闭时销毁,需要通过bean的destroy-method属性指定销毁方法
    *bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口，
且配置到IOC容器中，需要注意的是，bean后置处理器不是单独针对某一个bean生效，而是针对IOC容
器中所有bean都会执行
    * 注意:
    * 诺bean的作用域为单列时,生命周期为前三个步骤会在IOC容器执行
    * 诺bean的作用域为多列时，生命周期的前三个步骤在获取bean时执行
    *
    * */

    @Test
    public void test(){
        // ConfigurableApplicationContext 是ApplicationContext的子接口,其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}