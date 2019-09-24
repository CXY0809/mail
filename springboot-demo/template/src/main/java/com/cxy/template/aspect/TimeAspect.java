package com.cxy.template.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @program: template
 * @description: 切面
 * @author: cuixy
 * @create: 2019-08-08 16:01
 **/
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.cxy.template.controller.fastjson.FastjsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为:" + arg);
        }

        long start = System.currentTimeMillis();

        Object object = pjp.proceed();

        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));

        return object;
    }


}