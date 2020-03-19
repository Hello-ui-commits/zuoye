package io.cxy.jcartadministrationback.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class EmailUtil {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void send(String fromEmail,
                     String toEmaile,
                     String title,
                     String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmaile);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        logger.info("send email ended");
    }
}
