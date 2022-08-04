package com.atguigu.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-02 20:15
 * @Description:
 */

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    // @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("com.atguigu.spring.aop.xml.LoggerAspect.pointCut()")
    public void beforeMethod() {
        System.out.println("ValidateAspect-->前置通知");
    }
}