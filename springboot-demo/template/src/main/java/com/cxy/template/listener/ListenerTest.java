package com.cxy.template.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: template
 * @description: 自定义监听器
 * @author: cuixy
 * @create: 2019-08-08 15:51
 **/
public class ListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}