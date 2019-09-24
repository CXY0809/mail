package com.cxy.template.controller.basics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @program: template
 * @description: 当我们需要对不同环境使用不同的 Bean 时，可以通过 @Profile 注解进行区分
 * @author: cuixy
 * @create: 2019-08-08 13:30
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    @Profile("dev")
    public Runnable test1() {
        System.out.println("开发环境使用的 Bean");
        return () -> {};
    }

    @Bean
    @Profile("test")
    public Runnable test2() {
        System.out.println("测试环境使用的 Bean");
        return () -> {};
    }

    @Bean
    @Profile("pro")
    public Runnable test3() {
        System.out.println("生成环境使用的 Bean");
        return () -> {};
    }

}