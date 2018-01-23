package com.lxf.bp.bp.factory;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

public interface MessageFactory {

    public SimpleMailMessage buildSimpleMailMessage(String subject,String context,String... to);

    public MimeMessage buildMimeMessage( String subject, String context, Map<String,String> pics,String... to) throws MessagingException;

}
