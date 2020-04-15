package com.fms.reactiveservice.FeedBackApplication.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fms.reactiveservice.FeedBackApplication.entity.NotParticipatedFeedback;

import reactor.core.publisher.Mono;

public interface NotParticipatedFeedbackRepository extends ReactiveMongoRepository<NotParticipatedFeedback, Integer> {
	
	public Mono<NotParticipatedFeedback> findByemployeeId(Integer employeeId);

}
