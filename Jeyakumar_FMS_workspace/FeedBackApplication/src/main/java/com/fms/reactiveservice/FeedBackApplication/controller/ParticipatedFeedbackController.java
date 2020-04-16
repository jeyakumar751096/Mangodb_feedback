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

import com.fms.reactiveservice.FeedBackApplication.Service.ParticipatedFeedbackService;
import com.fms.reactiveservice.FeedBackApplication.entity.ParticipatedFeedback;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/email/Participated")
public class ParticipatedFeedbackController {
	
	@Autowired
	public ParticipatedFeedbackService participatedFeedbackService;
	
	@PostMapping("/saveFeedback")
	public Mono<ParticipatedFeedback> createParticipatedFeedback(@RequestBody ParticipatedFeedback participatedFeedback) {
		return participatedFeedbackService.createParticipated(participatedFeedback);
	}
	
	@GetMapping("/{employeeId}")
	public Mono<ResponseEntity<ParticipatedFeedback>> getNotParticipatedFeedback(@PathVariable Integer employeeId) {
		return participatedFeedbackService.getParticipatedFeedback(employeeId)
				.map(fetchId -> ResponseEntity.ok(fetchId))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/allFeedBackList")
	public Flux<ParticipatedFeedback> getAllParticipatedFeedback() {
		return participatedFeedbackService.getAllParticipatedFeedback();
	}
	
	@PutMapping("/updateFeedBack/{employeeId}")
	public Mono<ResponseEntity<ParticipatedFeedback>> updateNotParticipatedFeedback(@RequestBody ParticipatedFeedback participatedFeedback,
			@PathVariable Integer employeeId) {	
		return participatedFeedbackService.updateParticipatedFeedback(participatedFeedback, employeeId)
				.map(updated-> new ResponseEntity<>(updated, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@DeleteMapping("/deleteFeedBack/{employeeId}")
	public Mono<ResponseEntity<Void>> deleteParticipatedFeedback(@PathVariable Integer employeeId) {
		return  participatedFeedbackService.deleteParticipatedFeedback(employeeId);
	}

}
