package com.fms.reactiveservice.FeedBackApplication.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.reactiveservice.FeedBackApplication.Service.RegisterAndParticipatedMailPreparationService;
import com.fms.reactiveservice.FeedBackApplication.entity.OutReachEventInformation;
import com.fms.reactiveservice.FeedBackApplication.request.MailRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/email/preparation")
public class RegisterAndParticipatedMailPreparationController {
	
	@Autowired
	public RegisterAndParticipatedMailPreparationService registerAndParticipatedMailPreparationService;
	
	
	
	@GetMapping("allRegister")
	public Flux<OutReachEventInformation> getAllRegisteredAndParticipated() {
		return registerAndParticipatedMailPreparationService.getAllRegisteredAndParticipated();
	}
	
	
	@PostMapping("/callMailApi")
	public ResponseEntity<Mono<String>> callMailApi(@RequestBody MailRequest request){
		return registerAndParticipatedMailPreparationService.callMailApi(request);
	}

}
