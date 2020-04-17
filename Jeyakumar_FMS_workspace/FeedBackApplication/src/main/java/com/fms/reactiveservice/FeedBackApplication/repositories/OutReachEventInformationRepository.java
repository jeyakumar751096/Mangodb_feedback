package com.fms.reactiveservice.FeedBackApplication.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.reactiveservice.FeedBackApplication.entity.OutReachEventInformation;


@Repository
public interface OutReachEventInformationRepository extends ReactiveMongoRepository<OutReachEventInformation, Integer> {

}
