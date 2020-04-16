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

import com.fms.reactiveservice.FeedBackApplication.Service.AdminFeedbackQnAnswService;
import com.fms.reactiveservice.FeedBackApplication.entity.FeedbackQuestion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin/feedback")
public class AdminFeedbackQnAController {

	@Autowired
	public AdminFeedbackQnAnswService adminFeedbackQnAnswService;
	
	
	@PostMapping("/createFeedBackQnA")
	public Mono<FeedbackQuestion> createFeedBackQnA(@RequestBody FeedbackQuestion feedbackQuestion) {
		return adminFeedbackQnAnswService.createFeedBackQnA(feedbackQuestion);
	}
	
	// Get Question Id Feedback Question and Answer by Admin
	@GetMapping("/getFeedBackQnA/{feedbackQuestionId}")
	public Mono<ResponseEntity<FeedbackQuestion>> getFeedBackQnA(@PathVariable Integer feedbackQuestionId) {
		return adminFeedbackQnAnswService.getFeedBackQnA(feedbackQuestionId).map(fetchId -> ResponseEntity.ok(fetchId))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/allFeedBackQnAList")
	public Flux<FeedbackQuestion> getAllFeedBackQnA() {
		return adminFeedbackQnAnswService.getAllFeedBackQnA();
	}
	
	@PutMapping("updateFeedbackQuestion/{feedbackQuestionId}")
	public Mono<ResponseEntity<FeedbackQuestion>> updateFeedbackQuestion(@RequestBody FeedbackQuestion feedbackQuestion,
			@PathVariable Integer feedbackQuestionId) {
		return adminFeedbackQnAnswService.updateFeedbackQuestion(feedbackQuestion, feedbackQuestionId)
				.map(updateQnA -> new ResponseEntity<>(updateQnA, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping(value = "/getFeedbackTypeQuestions/{feedbackType}")//, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<FeedbackQuestion> getFeedbackTypeQuestions(String feedbackType){
		return adminFeedbackQnAnswService.getFeedbackTypeQuestions(feedbackType);
	}
	
	
	@DeleteMapping("/deleteQuestionId/{questionId}")
	public Mono<ResponseEntity<Void>> deleteQuestionId(@PathVariable Integer questionId) {
		return adminFeedbackQnAnswService.deleteQuestionId(questionId);
	}
	
}
