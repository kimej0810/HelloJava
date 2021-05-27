package com.example.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.EmailDTO;
import com.example.service.EmailService;

@RequestMapping(value="/email")
@Controller
public class EmailController {

    @Inject
    EmailService emailService;
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write() {
		return "/email/write";
	}
	@RequestMapping(value="/send", method = RequestMethod.POST)
	public String send(@ModelAttribute EmailDTO dto, Model model) {
		try {
			System.out.println("Message >"+dto.getMessage());
			System.out.println("ReceiveMail >"+dto.getReceiveMail());
			System.out.println("Sendermail >"+dto.getSenderMail());
			System.out.println("senderName >"+dto.getSenderName());
			System.out.println("subject >"+dto.getSubject());
			emailService.sendMail(dto);
			model.addAttribute("message","발송완료");
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("message","발송실패");
		}
		return "/email/write";
	}
	
}
