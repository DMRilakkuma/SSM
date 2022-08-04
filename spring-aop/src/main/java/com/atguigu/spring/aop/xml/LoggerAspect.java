package com.atguigu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-08-02 15:34
 * @Description: 1.在切面中, 需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知,在目标方法执行之前执行
 * @After：在finallu子句中执行的 <p>
 * @AfterReturning:返回通知,在目标对象方法返回之后执行
 * @AfterThrowing :异常通知，在目标对象的方法的catch子句中执行
 * 切入点表达式：设置在标识通知的注解的value属性中
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中的任意方法
 * ..表示任意的参数类型
 * 类的地方也可以使用*，表示包下的所有类
 * <p>
 * 3.重用切入点表达式
 * //Pointcut声明一个公共的切入点表达式
 * @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut(){
 * }
 * <p>
 * 使用方式@Before("pointCut()")
 * <p>
 * <p>
 * 3.获取连接点的信息
 * 在通知方法的参数位置,设置JoinPoint的参数,就可以获取连接点所对应的方法信息
 *
 *
 * 5.切面的优先级
 * 可以通过@Order注解的value属性设置优先级，默认值为Interger的最大值
 */
@Component
@Aspect  // 将当前组件标识为切面
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.aop.xml.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    // @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
    /*@Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")*/
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点所对应的方法的签名信息
        Signature signature = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",参数:" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + ",执行完毕");
    }


    // 在返回通知中诺要获取目标对象方法的返回值，只需要通过AfterReturning注解returning属性
    // 就可以将通知方法的某个参数指定为接受目标对象方法的返回值的参数
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        // 获取连接点的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + ",结果:" + result);
    }


    // 在异常通知中诺要获取目标对象方法的返回值，只需要通过AfterReturning注解returning属性
    // 就可以将通知方法的某个参数指定为接受目标对象方法的异常的参数
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex) {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + ",异常:" + ex);
    }


    @Around("pointCut()")
    // 环绕通知的方法的返回值一定要和目标对象的方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环境通知-->前置通知");
            // 表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}