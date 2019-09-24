package com.cxy.template.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: template
 * @description: 测试实体类
 * @author: cuixy
 * @create: 2019-08-12 11:32
 **/
@Document(collection = "t_department")
public class Department {

    @Id
    private String id;

    private String name;

    private String descr;


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }
}