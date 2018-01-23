package com.lxf.bp.mail.service;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface ConvertMailMessage {
    public void convertSimpleMailMessage(SimpleMailMessage... message);
    public void convertMimeMessage(MimeMessage... message) throws MessagingException;
}
