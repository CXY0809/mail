package com.cxy.template.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: template
 * @description: spring 3.0 之后自带的定时器
 * @author: cuixy
 * @create: 2019-08-09 10:45
 **/

@Component
public class Schedule {

    //@Scheduled(fixedRate = 2000)
    public void task() {

        //System.out.println("启动定时任务:" + new Date());
    }
}