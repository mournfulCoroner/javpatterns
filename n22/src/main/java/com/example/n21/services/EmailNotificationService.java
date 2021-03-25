package com.example.n21.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mail;

    @Autowired
    public EmailNotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmailNotification(String text){
        SimpleMailMessage mes = new SimpleMailMessage();
        mes.setFrom(mail);
        mes.setTo(mail);
        mes.setSubject("Уведомление о сохранении объекта");
        mes.setText(text);
        javaMailSender.send(mes);
    }
}
