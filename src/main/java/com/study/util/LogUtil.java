package com.study.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
@Order(2)
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

    /**
     * 环绕通知是spring中功能最强大的通知
     * 环绕通知的执行顺序是优于普通通知的，具体的执行顺序如下：
     * 环绕前置-->普通前置-->目标方法执行-->环绕正常结束/出现异常-->环绕后置-->普通后置-->普通返回或者异常
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(public int com.study.util.Calculator.*(int,int))")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        Object proceed = null;

        try {
            System.out.println("环绕前置通知：" + name + "方法开始，参数是：" + Arrays.asList(args));
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("环绕后置通知：" + name + "方法返回，结果是：" + proceed);
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知：" + name + "方法出现异常，异常信息是：" + throwable.getMessage());
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕后置通知：" + name + "方法结束");
        }
        return proceed;
    }
}