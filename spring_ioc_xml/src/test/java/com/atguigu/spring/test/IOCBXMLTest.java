package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-27 20:32
 * @Description:
 */

public class IOCBXMLTest {

    /*
    *  获取bean的三种方式:
    * 1. 根据bean的id获取
    *  2.根据bean的类型获取,注意：根据类型获取bean时，要求ioc容器中有且一个类型匹配的bean
    * 诺一个都没有类型匹配的bean,出现异常 NoSuchBeanDefinitionException
    * 诺有多个类型匹配的bean,出现异常 NoUniqueBeanDefinitionException
    *3.根据bean的id和类型获取
    * */

    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
        /*Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
        System.out.println(clazz);*/
       /* Clazz clazz = ioc.getBean("classOne", Clazz.class);
        System.out.println(clazz);*/

    }


    @Test
    public void testIOC(){
        // 获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 获取bean
        //Student studentOne = (Student) ioc.getBean("studentOne");
        // Student student = ioc.getBean(Student.class);
        // Student student = ioc.getBean("studentOne", Student.class);
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
}