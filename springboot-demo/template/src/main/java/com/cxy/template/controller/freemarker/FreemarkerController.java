package com.cxy.template.controller.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @program: template
 * @description: Freemarker 模版替代jsp
 * @author: cuixy
 * @create: 2019-08-08 14:52
 **/

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {

        map.put("msg", "Hello Freemarker");
        return "hello";
    }


}