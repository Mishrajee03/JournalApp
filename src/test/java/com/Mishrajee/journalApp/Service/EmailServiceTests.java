package com.Mishrajee.journalApp.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.mail.javamail.JavaMailSender;


@SpringBootTest
public class EmailServiceTests {



    @Autowired
    private EmailService emailService;


    @Disabled
    @Test
    void testSendEmail(){
        emailService.sendMail("hariomishrain17112006@gmail.com","learning Springboot email sender","it is crazy....");
    }
}
