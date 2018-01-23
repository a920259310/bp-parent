package com.lxf.bp.mail.service;

import com.lxf.bp.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;

@ContextConfiguration("classpath:spring-mail.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMailServiceImpl {

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void testSimpleMessage() throws Exception {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("920259310@qq.com");
        simpleMailMessage.setSubject("测试服务");
        simpleMailMessage.setText("https://render.alipay.com/p/f/fd-j6lzqrgm/guiderofmklvtvw.html?shareId=2088502862979664&campStr=p1j%2BdzkZl018zOczaHT4Z5CLdPVCgrEXq89JsWOx1gdt05SIDMPg3PTxZbdPw9dL&sign=v%2FiwvqvS6DeR5CiyQQoPliqCvrvitcS14%2FqUBNDBgrY%3D&scene=offlinePaymentNewSns");
        mailService.sendSimpleMailMessage(simpleMailMessage);
    }

    @Test
    public void testSendMimeMessage() throws Exception {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("920259310@qq.com");
        helper.setSubject("测试图片服务");

        helper.setText("<html><body><img src='cid:testLogo'>"
                + "<h4>Hello World!!!</h4>"
                + "</body></html>", true);//第二个参数表明这是一个HTML
        //src='cid:testLogo'表明在消息中会有一部分是图片并以testLogo来进行标识
        ClassPathResource image = new ClassPathResource("pic/2.png");


        helper.addInline("testLogo", image);//添加内联图片，第一个参数表明内联图片的标识符，第二个参数是图片的资源引用
        mailService.sendMimeMessage(message);
    }

    @Test
    public void testSendMimeMessageByTemplate() throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String fileText = FileUtils.getFileTextFromClassPath("html/pageTemplate.html");

        helper.setTo("920259310@qq.com");
        helper.setSubject("测试图片服务");
        helper.setText(fileText,true);
        ClassPathResource image = new ClassPathResource("pic/2.png");

        helper.addInline("testLogo", image);//添加内联图片，第一个参数表明内联图片的标识符，第二个参数是图片的资源引用
        mailService.sendMimeMessage(message);
    }

}
