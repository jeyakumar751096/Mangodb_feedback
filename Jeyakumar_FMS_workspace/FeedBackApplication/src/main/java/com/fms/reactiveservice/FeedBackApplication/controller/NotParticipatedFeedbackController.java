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

import com.fms.reactiveservice.FeedBackApplication.Service.NotParticipatedFeedbackService;
import com.fms.reactiveservice.FeedBackApplication.entity.NotParticipatedFeedback;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/email/NotParticipat")
public class NotParticipatedFeedbackController {
	
	@Autowired
	public NotParticipatedFeedbackService notParticipatedFeedbackService;

	@PostMapping("/saveFeedback")
	public Mono<NotParticipatedFeedback> createNotParticipatedFeedback(@RequestBody NotParticipatedFeedback notParticipatedFeedback) {
		return notParticipatedFeedbackService.createNotParticipated(notParticipatedFeedback);
	}
	
	@GetMapping("/{employeeId}")
	public Mono<ResponseEntity<NotParticipatedFeedback>> getNotParticipatedFeedback(@PathVariable Integer employeeId) {
		return notParticipatedFeedbackService.getNotParticipatedFeedback(employeeId)
				.map(fetchId -> ResponseEntity.ok(fetchId))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/allFeedBackList")
	public Flux<NotParticipatedFeedback> getAllNotParticipatedFeedback() {
		return notParticipatedFeedbackService.getAllNotParticipatedFeedback();
	}
	
	@PutMapping("/updateFeedBack/{employeeId}")
	public Mono<ResponseEntity<NotParticipatedFeedback>> updateNotParticipatedFeedback(@RequestBody NotParticipatedFeedback notParticipatedFeedback,
			@PathVariable Integer employeeId) {	
		return notParticipatedFeedbackService.updateNotParticipatedFeedback(notParticipatedFeedback, employeeId)
				.map(updated-> new ResponseEntity<>(updated, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@DeleteMapping("/deleteFeedBack/{employeeId}")
	public Mono<ResponseEntity<Void>> deleteNotParticipatedFeedback(@PathVariable Integer employeeId) {
		return  notParticipatedFeedbackService.deleteNotParticipatedFeedback(employeeId);
	}
}
