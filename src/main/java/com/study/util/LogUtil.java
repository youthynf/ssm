package com.study.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class LogUtil {
    @Before("execution( public int com.study.util.Calculator.*(int,int))")
    public static void start(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format + " | 方法开始执行，参数是：" + Arrays.asList(args) + ", 名称为：" + name);
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