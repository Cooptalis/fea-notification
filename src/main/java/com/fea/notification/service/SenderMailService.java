package com.fea.notification.service;

public interface SenderMailService {

    public void sendMail(String to, String subject, String message);
}
