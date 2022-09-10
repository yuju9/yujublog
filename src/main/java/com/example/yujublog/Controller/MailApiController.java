package com.example.yujublog.Controller;

import com.example.yujublog.Service.EmailService;
import com.example.yujublog.dto.ResponseDto;
import com.example.yujublog.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MailApiController {
    @Autowired
    private EmailService emailService;


    @PostMapping("/ask")
    public ResponseDto<Integer> sendMail(@RequestBody Mail mail) {
        emailService.sendSimpleMessage(mail);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
