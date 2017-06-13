package com.proyectoIntegrado.webRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrado.model.Email;
import com.proyectoIntegrado.service.EmailService;

@RestController
public class EmailController extends AbstractResourceController {

	private final EmailService emailService;
	 
	@Autowired
	public EmailController(EmailService emailService){
		this.emailService = emailService;
	}
	
	@RequestMapping(value ="enviarEmail", method = RequestMethod.POST)
	public void enviarEmail(@RequestBody Email email){
		String toEmail = email.getToEmail();
		String subject = email.getSubject();
		String message = email.getMessage();
		emailService.sendMail(toEmail, subject, message);
	}
}
