package com.example.service;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.EmailDTO;

@Service
public class EmailServiceImpl implements EmailService {
 
    @Inject
    JavaMailSender mailSender;
 
    @Override
    public void sendMail(EmailDTO dto) {
        try {

            MimeMessage msg = mailSender.createMimeMessage();
 

            msg.addRecipient(RecipientType.TO, new InternetAddress(dto.getReceiveMail()));

 

            msg.addFrom(new InternetAddress[] { new InternetAddress(dto.getSenderMail(), dto.getSenderName()) });
 

            msg.setSubject(dto.getSubject(), "UTF-8");
            //String htmlContent = "<div style='width:300px;height:300px;background-color:blue'>"+ dto.getMessage()+"</div>";
            //msg.setText(htmlContent, true);
            msg.setText(dto.getMessage(), "UTF-8");
 
      
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper 
//            = new MimeMessageHelper(message, true);
//            helper.setTo("test@host.com");
//            helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true);
 

            mailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
