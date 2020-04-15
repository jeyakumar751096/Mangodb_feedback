package com.fms.reactiveservice.FeedBackApplication.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.reactiveservice.FeedBackApplication.entity.FeedbackQuestion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AdminFeedbackQnAnswRepository extends ReactiveMongoRepository<FeedbackQuestion, Integer>{
	
	public Mono<FeedbackQuestion> findByquestionId(Integer questionId);
	
	public Flux<FeedbackQuestion> findByfeedbackType(String feedbackType);

}
