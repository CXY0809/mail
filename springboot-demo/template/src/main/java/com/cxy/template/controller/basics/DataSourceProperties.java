package com.cxy.template.controller.basics;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: template
 * @description: 装配整个对象
 * @author: cuixy
 * @create: 2019-08-08 14:28
 **/
@Component
@ConfigurationProperties(prefix="ds")
public class DataSourceProperties {

    private String url;

    private String driverClassName;

    private String userName;

    private String password;


    public void show() {
        System.out.println("ds.url=" + this.url);
        System.out.println("ds.driverClassName=" + this.driverClassName);
        System.out.println("ds.userName=" + this.userName);
        System.out.println("ds.password=" +this.password);
    }

    public String getUrl() {
        return url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}