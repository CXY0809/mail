package com.cxy.template.KdApiSearchDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: template
 * @description: 接收推送的内容
 * @author: cuixy
 * @create: 2019-12-02 16:33
 **/
@RestController
public class KdniaoPushAPI {


    //接收快递信息
    @GetMapping("/receiveMessages")
    public String receiveMessages(String logisticslist) {
        if(logisticslist != null){
            return "a";
        }
        return "b";
    }


}