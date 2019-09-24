package com.cxy.template;

import com.cxy.template.mail.JavaMailComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: template
 * @description: 邮件测试
 * @author: cuixy
 * @create: 2019-08-08 17:50
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailComponent javaMailComponent;

    @Test
    public void test() {
        this.javaMailComponent.sendMail("56696508@qq.com");
    }
}