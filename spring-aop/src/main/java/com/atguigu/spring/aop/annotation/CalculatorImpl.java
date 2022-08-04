package com.atguigu.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-01 19:16
 * @Description:
 */
@Component
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println("方法内部：result=" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        System.out.println("方法内部：result=" + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        System.out.println("方法内部：result=" + result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        System.out.println("方法内部：result=" + result);
        return result;
    }
}