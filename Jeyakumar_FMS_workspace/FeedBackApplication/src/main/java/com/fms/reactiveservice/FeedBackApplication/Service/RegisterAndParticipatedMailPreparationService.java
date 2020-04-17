package com.fms.reactiveservice.FeedBackApplication.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.reactiveservice.FeedBackApplication.entity.OutReachEventInformation;
import com.fms.reactiveservice.FeedBackApplication.repositories.OutReachEventInformationRepository;
import com.fms.reactiveservice.FeedBackApplication.request.EmailDetails;
import com.fms.reactiveservice.FeedBackApplication.request.MailRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RegisterAndParticipatedMailPreparationService {
	
	@Autowired
	public OutReachEventInformationRepository outReachEventInformationRepository;
	
    WebClient client;
	
	@PostConstruct
	public void init() {
		client = WebClient.builder().baseUrl("http://localhost:8086/fms/mail")
					.defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	public Flux<OutReachEventInformation> getAllRegisteredAndParticipated() {
		return outReachEventInformationRepository.findAll();
	}
	
	public ResponseEntity<Mono<String>> callMailApi( MailRequest request){
		
		List<MailRequest> requestObject=new ArrayList<MailRequest>();
		MailRequest mails=new MailRequest();
		List<EmailDetails> eDetails=new ArrayList<EmailDetails>();
		String URI="/participated";
		Mono<String> result=client.post().uri(URI).body(Mono.just(request),MailRequest.class)
				.retrieve()
				.bodyToMono(String.class);
		return ResponseEntity.ok(result);
	}
	
	
	

}
