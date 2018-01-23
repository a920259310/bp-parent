package com.lxf.bp.mail.service.impl;

import com.lxf.bp.mail.config.MailEnvConfig;
import com.lxf.bp.mail.service.ConvertMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class ConvertMailMessageImpl implements ConvertMailMessage {

    @Autowired
    private MailEnvConfig mailEnvConfig;

    @Override
    public void convertSimpleMailMessage(SimpleMailMessage... message) {
        for(SimpleMailMessage simpleMailMessage : message){
            simpleMailMessage.setFrom(mailEnvConfig.getFormName());
        }
    }

    @Override
    public void convertMimeMessage(MimeMessage... mimeMessages) throws MessagingException {
        for(MimeMessage mimeMessage : mimeMessages){
            mimeMessage.setFrom(new InternetAddress(mailEnvConfig.getFormName()));
        }
    }
}
