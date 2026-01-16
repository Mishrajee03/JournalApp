package com.Mishrajee.journalApp.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {


    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendMail(String to,String subject,String body){
        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom("mishrajeein2006@gmail.com");
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);
            System.out.println("SUCCESS: Email sent to " + to);
        } catch (Exception e){
            log.error("Exception while sending email.",e);
        }
    }
}
