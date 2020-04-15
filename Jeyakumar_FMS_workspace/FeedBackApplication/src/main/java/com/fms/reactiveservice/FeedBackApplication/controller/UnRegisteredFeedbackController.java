package com.fms.reactiveservice.FeedBackApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.reactiveservice.FeedBackApplication.Service.UnRegisteredFeedbackService;
import com.fms.reactiveservice.FeedBackApplication.entity.UnRegisteredFeedback;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/email/UnRegistered")
public class UnRegisteredFeedbackController {

	@Autowired
	public UnRegisteredFeedbackService unRegisteredFeedbackService;
	
	@PostMapping("/saveFeedback")
	public Mono<UnRegisteredFeedback> createUnRegistered(@RequestBody UnRegisteredFeedback unRegisteredFeedback) {
		return unRegisteredFeedbackService.createUnRegistered(unRegisteredFeedback);
	}
	
	@GetMapping("/{employeeId}")
	public Mono<ResponseEntity<UnRegisteredFeedback>> getUnRegisteredFeedback(@PathVariable Integer employeeId) {
		return unRegisteredFeedbackService.getUnRegisteredFeedback(employeeId)
				.map(fetchId -> ResponseEntity.ok(fetchId))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/allFeedBackList")
	public Flux<UnRegisteredFeedback> getAllUnRegisteredFeedback() {
		return unRegisteredFeedbackService.getAllUnRegisteredFeedback();
	}
	
	@PutMapping("/updateFeedBack/{employeeId}")
	public Mono<ResponseEntity<UnRegisteredFeedback>> updateUnRegisteredFeedback(@RequestBody UnRegisteredFeedback unRegisteredFeedback,
			@PathVariable Integer employeeId) {	
		return unRegisteredFeedbackService.updateUnRegisteredFeedback(unRegisteredFeedback, employeeId)
				.map(updated-> new ResponseEntity<>(updated, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@DeleteMapping("/deleteFeedBack/{employeeId}")
	public Mono<ResponseEntity<Void>> deleteUnRegisteredFeedback(@PathVariable Integer employeeId) {
		return  unRegisteredFeedbackService.deleteUnRegisteredFeedback(employeeId);
	}
}