package com.lxf.bp.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:spring-mail.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestInit{
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void testInit(){
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("lian920259310@163.com");

        message.setText("这是一个邮件测试!");
        message.setSubject("测试邮件发送");
        message.setTo("920259310@qq.com");

        javaMailSender.send(message);
        System.out.println(javaMailSender);
    }

    @Test
    public void testSendMail(){

    }
}
