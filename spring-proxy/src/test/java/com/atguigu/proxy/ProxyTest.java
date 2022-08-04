package com.atguigu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-01 19:51
 * @Description:
 */

public class ProxyTest {

    /*
    * 动态代理有两种:
    * 1. JDK动态代理,要求必须有接口，最终生成的代理类和目标类实现相同的接口,在com.sun.proxy包下面,类名为￥proxy2
    * 2. CGLIB动态代理,最终生成的代理会自动继承目标类，并且和类在相同的包下
    * */

    @Test
    public void testProxy(){
       /* CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1, 2);*/
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1, 0);

    }
}