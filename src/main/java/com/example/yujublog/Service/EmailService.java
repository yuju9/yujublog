package com.example.yujublog.Service;

import com.example.yujublog.model.Mail;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender emailSender;

    private static final String MyAddress = "lah0930@gmail.com";

    public void sendSimpleMessage(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();


        message.setFrom(mail.getEmail());
        message.setTo(MyAddress);
        message.setSubject("[ASK]" + mail.getTitle());
        message.setText(mail.getMessage());
        emailSender.send(message);
    }

}
