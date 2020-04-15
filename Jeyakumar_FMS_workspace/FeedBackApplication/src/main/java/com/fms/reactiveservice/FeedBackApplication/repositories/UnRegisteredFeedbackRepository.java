package com.fms.reactiveservice.FeedBackApplication.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.reactiveservice.FeedBackApplication.entity.UnRegisteredFeedback;

import reactor.core.publisher.Mono;

@Repository
public interface UnRegisteredFeedbackRepository extends ReactiveMongoRepository<UnRegisteredFeedback, Integer> {
	
	public Mono<UnRegisteredFeedback> findByemployeeId(Integer employeeId);

}