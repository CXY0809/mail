package com.cxy.template.entity;

import java.io.Serializable;

/**
 * @program: template
 * @description: mybatis
 * @author: cuixy
 * @create: 2019-08-09 14:41
 **/
public class Department implements Serializable {

    private static final long serialVersionUID = 6067283535977178571L;

    private Integer id;

    private String name;

    private String descr;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}