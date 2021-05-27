package com.example.service;

import javax.inject.Inject;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.MailDTO;
import com.example.util.MailHandler;

@Service
public class MailServiceImpl implements MailService {
	@Inject
	JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "tobe202105@gmail.com";
	
	@Override
	public void mailSend(MailDTO mailDTO) {
		try {
			MailHandler mailHandler = new MailHandler(mailSender);
			//받는사람
			mailHandler.setTo(mailDTO.getAddress());
			//보내는사람
			mailHandler.setFrom(FROM_ADDRESS);
			//제목
			mailHandler.setSubject(mailDTO.getTitle());
			//HTML Layout
			String htmlContent = "<div style='width:400px;height:400px;margin:auto;border:1px solid black;'>"+mailDTO.getMessage()+"</div>";
			mailHandler.setText(htmlContent, true);
			//첨부파일
			//String filepath = "D:\\api_dev\\email\\src\\main\\webapp\\resources\\file\\";
			//mailHandler.setAttach("profile.png", "profile.png");
			//이미지삽입
			//mailHandler.setInline("profile", "/resources/file/profile.png");
			mailHandler.send();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
