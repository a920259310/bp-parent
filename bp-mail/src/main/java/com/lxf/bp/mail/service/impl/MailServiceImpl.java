package com.lxf.bp.mail.service.impl;

import com.lxf.bp.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ConvertMailMessageImpl convertMailMessage;

    @Override
    public void sendSimpleMailMessage(SimpleMailMessage... message) throws Exception {
        if (javaMailSender instanceof JavaMailSenderImpl) {
            JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) javaMailSender;

            convertMailMessage.convertSimpleMailMessage(message);

            mailSenderImpl.send(message);
        }
    }

    @Override
    public void sendMimeMessage(MimeMessage... message) throws Exception {
        if (javaMailSender instanceof JavaMailSenderImpl) {
            JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) javaMailSender;

            convertMailMessage.convertMimeMessage(message);

            mailSenderImpl.send(message);
        }
    }

}
