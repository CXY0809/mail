package com.cxy.template.controller.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: template
 * @description: 测试 Controller
 * @author: cuixy
 * @create: 2019-08-08 11:41
 **/

@RestController
public class TestController {

    @Value("${ds.userName}")
    private String userName;

    @Autowired
    private Environment environment;


    /**
     * 通过两种方式 获取配置文件内的参数
     */
    @GetMapping("/helloworld1")
    public void show() {
        System.out.println("ds.userName:" + this.userName);
        System.out.println("ds.password:" + this.environment.getProperty("ds.password"));


    }



    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld cxy";
    }



}