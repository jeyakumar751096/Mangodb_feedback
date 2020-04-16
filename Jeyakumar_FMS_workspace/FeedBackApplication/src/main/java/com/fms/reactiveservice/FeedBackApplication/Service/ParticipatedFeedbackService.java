package com.fms.reactiveservice.FeedBackApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.reactiveservice.FeedBackApplication.entity.ParticipatedFeedback;
import com.fms.reactiveservice.FeedBackApplication.repositories.ParticipatedFeedbackRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParticipatedFeedbackService {
	
	@Autowired
	public ParticipatedFeedbackRepository participatedFeedbackRepository;
	
	public Mono<ParticipatedFeedback> createParticipated(ParticipatedFeedback participatedFeedback) {
		return participatedFeedbackRepository.save(participatedFeedback);
	}
	
	public Mono<ParticipatedFeedback> getParticipatedFeedback(Integer employeeId) {
		return participatedFeedbackRepository.findByemployeeId(employeeId);
	}
	
	public Flux<ParticipatedFeedback> getAllParticipatedFeedback() {
		return participatedFeedbackRepository.findAll();
	}
	
	public Mono<ParticipatedFeedback> updateParticipatedFeedback(ParticipatedFeedback participatedFeedback,
			Integer employeeId) {		
		return participatedFeedbackRepository.findByemployeeId(employeeId).flatMap(existing -> {
			existing.setEmployeeId(participatedFeedback.getEmployeeId());
			existing.setEventId(participatedFeedback.getEventId());
			existing.setRating(participatedFeedback.getRating());
			existing.setActivityLike(participatedFeedback.getActivityLike());
			existing.setActivityImproved(participatedFeedback.getActivityImproved()); 
			return participatedFeedbackRepository.save(existing);
		});
	}
	
	
	
	public Mono<ResponseEntity<Void>> deleteParticipatedFeedback( Integer employeeId) {
		return participatedFeedbackRepository.findByemployeeId(employeeId)
				.flatMap(participatedFeedback -> participatedFeedbackRepository.delete(participatedFeedback)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	

}
