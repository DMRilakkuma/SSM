package com.atguigu.spring.proxy;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-01 19:41
 * @Description:
 */

public class CalculatorStaticProxy implements Calculator{

    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        int result = 0;
        try {
            System.out.println("日志,方法:add,参数:a="+a+",b="+b);
            result = target.add(a, b);
            System.out.println("日志,方法:add,结果:result=" + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("日志,方法:sub,参数:a="+a+",b="+b);
        int result = target.sub(a, b);
        System.out.println("日志,方法:sub,结果:result=" + result);
        return 0;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("日志,方法:mul,参数:a="+a+",b="+b);
        int result = target.mul(a, b);
        System.out.println("日志,方法:mul,结果:result=" + result);
        return 0;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("日志,方法:div,参数:a="+a+",b="+b);
        int result = target.div(a, b);
        System.out.println("日志,方法:div,结果:result=" + result);
        return 0;
    }
}