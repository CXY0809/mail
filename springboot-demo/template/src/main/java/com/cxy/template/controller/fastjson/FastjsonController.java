package com.cxy.template.controller.fastjson;

import com.cxy.template.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @program: template
 * @description: Fastjson 工具类
 * @author: cuixy
 * @create: 2019-08-08 15:18
 **/
@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("fastjson")
public class FastjsonController {

    //@RequestMapping("/test")
    //@ResponseBody
    //跨域解决
    //@CrossOrigin(origins="http://localhost:8080")


    /**
     * 注意，上边的方法是用 @GetMapping 注解，如果只是使用 @RequestMapping 注解，
     * 不配置 method 属性，那么 API 文档会生成 7 种请求方式。
     */
    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @GetMapping("/test/{name}")

    public User test(@PathVariable("name") String name) {
        User user = new User();

        user.setId(1);
        user.setUsername(name);
        user.setPassword("jack123");
        user.setBirthday(new Date());

        // 模拟异常
        //int i = 1/0;


        return user;
    }


}