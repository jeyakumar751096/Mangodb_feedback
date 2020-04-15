package com.fms.reactiveservice.FeedBackApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.reactiveservice.FeedBackApplication.entity.FeedbackQuestion;
import com.fms.reactiveservice.FeedBackApplication.repositories.AdminFeedbackQnAnswRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AdminFeedbackQnAnswService {
	
	@Autowired
	public AdminFeedbackQnAnswRepository adminFeedbackQnAnswRepository;
	
	
	public Mono<FeedbackQuestion> createFeedBackQnA(FeedbackQuestion feedbackQuestion) {
		return adminFeedbackQnAnswRepository.save(feedbackQuestion);
	}
	
	public Mono<FeedbackQuestion> getFeedBackQnA(Integer feedbackQuestionId) {
		return adminFeedbackQnAnswRepository.findByquestionId(feedbackQuestionId);
	}
	
	public Flux<FeedbackQuestion> getAllFeedBackQnA() {
		return adminFeedbackQnAnswRepository.findAll();
	}
	
	public Mono<FeedbackQuestion> updateFeedbackQuestion(FeedbackQuestion feedbackQuestion,
			Integer feedbackQuestionId) {		
		return adminFeedbackQnAnswRepository.findByquestionId(feedbackQuestionId).flatMap(existingQnA -> {
			existingQnA.setQuestion(feedbackQuestion.getQuestion());
			existingQnA.setFeedbackType(feedbackQuestion.getFeedbackType());
			existingQnA.setQuestionType(feedbackQuestion.getQuestionType());
			existingQnA.setFeedbackQuestionAnswer(feedbackQuestion.getFeedbackQuestionAnswer());
			return adminFeedbackQnAnswRepository.save(existingQnA);
		});
	}
	
	
	public Flux<FeedbackQuestion> getFeedbackTypeQuestions(String feedbackType){
		return adminFeedbackQnAnswRepository.findByfeedbackType(feedbackType);
	}
	
	public Mono<ResponseEntity<Void>> deleteQuestionId( Integer questionId) {
		return adminFeedbackQnAnswRepository.findByquestionId(questionId)
				.flatMap(existingQnA -> adminFeedbackQnAnswRepository.delete(existingQnA)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	

}
