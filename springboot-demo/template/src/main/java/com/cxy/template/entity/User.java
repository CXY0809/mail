package com.cxy.template.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @program: template
 * @description: 用户
 * @author: cuixy
 * @create: 2019-08-08 15:16
 **/
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    @JSONField(format="yyyy-MM-dd")
    private Date birthday;


}