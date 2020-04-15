package com.fms.reactiveservice.FeedBackApplication.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.reactiveservice.FeedBackApplication.entity.PmoDetails;

import reactor.core.publisher.Mono;


@Repository
public interface RolePmoDetailsRepository extends ReactiveMongoRepository<PmoDetails, Integer> {
	
	public Mono<PmoDetails> findByEmployeeId(Integer employeeId);	

}
