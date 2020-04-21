package com.cxy.template.controller.newWrit;

import java.util.Random;

/**
 * @program: template
 * @description: 1.8流式编程。
 * @author: cuixy
 * @create: 2020-04-16 17:33
 **/
public class streamCod {

    public static void main(String[] args) {

        //随机展示 1 至 50 之间不重复的整数并进行排序。实际上，你的关注点首先是创建一个有序集合。使用流式编程，你就可以简单的这样做：
        new Random(47)
                .ints(1, 50)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);


    }
}