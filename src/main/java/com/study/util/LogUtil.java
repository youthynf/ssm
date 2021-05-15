package com.study.util;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtil {
    @Before("execution( public int com.study.util.Calculator.*(int,int))")
    public static void start(){
//        System.out.println("XXX方法开始执行，使用的参数是："+ Arrays.asList(objects));
//        System.out.println(method.getName()+"方法开始执行，参数是："+ Arrays.asList(objects));
        System.out.println("方法开始执行，参数是：");
    }

    @AfterReturning("execution( public int com.study.util.Calculator.*(int,int))")
    public static void stop(){
//        System.out.println("XXX方法执行结束，结果是："+ Arrays.asList(objects));
//        System.out.println(method.getName()+"方法执行结束，结果是："+ Arrays.asList(objects));
        System.out.println("方法执行完成，结果是：");

    }

    @AfterThrowing("execution( public int com.study.util.Calculator.*(int,int))")
    public static void logException(){
//        System.out.println(method.getName()+"方法出现异常："+ e.getMessage());
        System.out.println("方法出现异常：");
    }

    @After("execution( public int com.study.util.Calculator.*(int,int))")
    public static void end(){
//        System.out.println(method.getName()+"方法执行结束了......");
        System.out.println("方法执行结束了......");
    }
}