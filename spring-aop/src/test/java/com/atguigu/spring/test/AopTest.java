package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-02 18:06
 * @Description:
 */

public class AopTest {

    @Test
    public void testAopByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10,1);
    }
}