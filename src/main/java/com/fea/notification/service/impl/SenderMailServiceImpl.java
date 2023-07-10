package com.fea.notification.service.impl;

import com.fea.notification.constant.ConfigConstant;
import com.fea.notification.service.SenderMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SenderMailServiceImpl implements SenderMailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(String to, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(ConfigConstant.MAIL_SENDER_FROM);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(message);

        this.javaMailSender.send(simpleMailMessage);

    }
}
