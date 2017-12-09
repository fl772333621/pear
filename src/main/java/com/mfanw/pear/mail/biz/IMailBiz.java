package com.mfanw.pear.mail.biz;

import java.util.List;

import javax.mail.MessagingException;

/**
 * <b>邮件发送服务</b>
 * 
 * @version 2017年11月2日 下午1:59:23
 * @author mengwei
 */
public interface IMailBiz {

    /**
     * 发送邮件给一个收件人
     *
     * @param recipient 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendText(String recipient, String subject, String content);

    /**
     * 发送邮件给多个收件人
     *
     * @param recipients 收件人列表
     * @param subject 主题
     * @param content 内容
     */
    public void sendText(List<String> recipients, String subject, String content);

    /**
     * 发送邮件给一个收件人
     *
     * @param recipient 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlText(String recipient, String subject, String content) throws MessagingException;

    /**
     * 发送邮件给多个收件人
     *
     * @param recipients 收件人列表
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlText(List<String> recipients, String subject, String content) throws MessagingException;
}
