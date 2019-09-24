package com.cxy.template;

import com.cxy.template.controller.basics.DataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//启动定时任务
//@EnableScheduling

//开启缓存功能
//@EnableCaching


@SpringBootApplication()
public class TemplateApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(TemplateApplication.class, args);

        //初始化加载对象bean
        //run.getBean(DataSourceProperties.class).show();

    }

}
