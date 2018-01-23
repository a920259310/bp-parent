package com.lxf.bp.mail.service;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface MailService {

    /**
     * 纯文本邮件发送服务
     * @param message
     * @throws Exception
     */
    public void sendSimpleMailMessage(SimpleMailMessage... message) throws Exception;

    /**
     * 附件及富文本发送接口
     * @param message
     * @throws Exception
     */
    public void sendMimeMessage(MimeMessage... message) throws Exception;


}
