package ru.yakimovvn.cv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.yakimovvn.cv.dto.MessageDto;
import ru.yakimovvn.cv.service.interfaces.Sender;

/**
 * Create by Vladimir Yakimov on 04.09.2022
 * cv
 **/

@Service
public class SenderImpl implements Sender {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.to}")
    private String mailTo;

    @Override
    public void send(MessageDto message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("СV");
        mailMessage.setTo(mailTo);
        mailMessage.setSubject("Message from CV");
        mailMessage.setText(String.format("User: %s \n E-mail: %s Topic: %s \n %s", message.getUser(), message.getEmail(), message.getTopic(), message.getMessage()));
        emailSender.send(mailMessage);
    }
}
