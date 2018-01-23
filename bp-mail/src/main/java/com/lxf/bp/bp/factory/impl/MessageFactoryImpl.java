package com.lxf.bp.bp.factory.impl;

import com.lxf.bp.bp.factory.MessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Set;

@Service
public class MessageFactoryImpl implements MessageFactory {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public SimpleMailMessage buildSimpleMailMessage(String subject, String context, String... to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(context);

        return simpleMailMessage;
    }

    @Override
    public MimeMessage buildMimeMessage(String subject, String context, Map<String, String> pics, String... to) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(context);

        Set<Map.Entry<String, String>> entries = pics.entrySet();

        for(Map.Entry<String, String> er : entries){
            ClassPathResource image = new ClassPathResource(er.getValue());
            helper.addInline(er.getKey(), image);
        }
        return message;
    }
}
