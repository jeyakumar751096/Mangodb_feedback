package com.fms.mongo.SpringMailFms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.mongo.SpringMailFms.entity.EmailDetails;
import com.fms.mongo.SpringMailFms.entity.MailRequest;
import com.fms.mongo.SpringMailFms.serviceImpl.FMSMailServiceImpl;

@RestController
@RequestMapping("/fms/mail")
public class SpringMailFmsController {

	
private static final Logger log=LoggerFactory.getLogger(SpringMailFmsController.class);
	
	@Autowired
	private FMSMailServiceImpl mailService;
	
	@PostMapping("/participated")
	public ResponseEntity<String> mailProcessed(@RequestBody MailRequest request) {
		log.info("/participated --- >service called"+request.getEmailDetails().size());
		if(request !=null) {
			for(EmailDetails req:request.getEmailDetails()) {
				((FMSMailServiceImpl) mailService).sendMail(req.getEmpMailId(),req.getSubject(), req.getMessage(),req);
			}
		}	
		return ResponseEntity.ok("Mail Sent successfully");
	}
}
