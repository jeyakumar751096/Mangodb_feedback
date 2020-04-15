package com.fms.reactiveservice.FeedBackApplication.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.reactiveservice.FeedBackApplication.entity.ParticipatedFeedback;

import reactor.core.publisher.Mono;


@Repository
public interface ParticipatedFeedbackRepository extends ReactiveMongoRepository<ParticipatedFeedback, Integer> {
	
	public Mono<ParticipatedFeedback> findByemployeeId(Integer employeeId);

}
