package com.mfanw.pear.mail.biz.impl;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mfanw.pear.mail.biz.IMailBiz;

/**
 * <b>邮件发送实例</b>
 * 
 * @version 2017年11月9日 下午6:24:54
 * @author mengwei
 */
@Service
public class MailBizImpl implements IMailBiz {

    /**
     * 发件人需要与登陆邮箱的账号相同
     */
    @Value("${mail.username}")
    private String username;

    /**
     * 需在spring.xml中配置相关bean并初始化
     */
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendText(String recipient, String subject, String content) {
        if (recipient == null) {
            return;
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(username);
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setSubject(subject == null ? "" : subject);
        simpleMailMessage.setText(content == null ? "" : content);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendText(List<String> recipients, String subject, String content) {
        if (recipients == null || recipients.isEmpty()) {
            return;
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(username);
        simpleMailMessage.setTo(recipients.toArray(new String[recipients.size()]));
        simpleMailMessage.setSubject(subject == null ? "" : subject);
        simpleMailMessage.setText(content == null ? "" : content);
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendHtmlText(String recipient, String subject, String content) throws MessagingException {
        if (recipient == null) {
            return;
        }
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(username);
        helper.setTo(recipient);
        helper.setSubject(subject == null ? "" : subject);
        helper.setText(content == null ? "" : content, true);
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendHtmlText(List<String> recipients, String subject, String content) throws MessagingException {
        if (recipients == null || recipients.isEmpty()) {
            return;
        }
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(username);
        helper.setTo(recipients.toArray(new String[0]));
        helper.setSubject(subject == null ? "" : subject);
        helper.setText(content == null ? "" : content, true);
        mailSender.send(mimeMessage);
    }

}
