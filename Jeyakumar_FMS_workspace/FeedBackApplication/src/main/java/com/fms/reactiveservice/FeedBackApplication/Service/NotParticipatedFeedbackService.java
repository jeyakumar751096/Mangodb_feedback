package com.fms.reactiveservice.FeedBackApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.reactiveservice.FeedBackApplication.entity.NotParticipatedFeedback;
import com.fms.reactiveservice.FeedBackApplication.repositories.NotParticipatedFeedbackRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NotParticipatedFeedbackService {
	
	
	@Autowired
	public NotParticipatedFeedbackRepository notParticipatedFeedbackRepository;
	
	public Mono<NotParticipatedFeedback> createNotParticipated(NotParticipatedFeedback notParticipatedFeedback) {
		return notParticipatedFeedbackRepository.save(notParticipatedFeedback);
	}
	
	public Mono<NotParticipatedFeedback> getNotParticipatedFeedback(Integer employeeId) {
		return notParticipatedFeedbackRepository.findByemployeeId(employeeId);
	}
	
	public Flux<NotParticipatedFeedback> getAllNotParticipatedFeedback() {
		return notParticipatedFeedbackRepository.findAll();
	}
	
	public Mono<NotParticipatedFeedback> updateNotParticipatedFeedback(NotParticipatedFeedback notParticipatedFeedback,
			Integer employeeId) {		
		return notParticipatedFeedbackRepository.findByemployeeId(employeeId).flatMap(existing -> {
			existing.setEmployeeId(notParticipatedFeedback.getEmployeeId());
			existing.setEventId(notParticipatedFeedback.getEventId());
			existing.setQuestionId(notParticipatedFeedback.getQuestionId());
			existing.setAnswerId(notParticipatedFeedback.getAnswerId());
			existing.setEventName(notParticipatedFeedback.getEventName());
			existing.setBaseLocation(notParticipatedFeedback.getBaseLocation());
			existing.setBeneficiaryName(notParticipatedFeedback.getBeneficiaryName());
			return notParticipatedFeedbackRepository.save(existing);
		});
	}
	
	
	
	public Mono<ResponseEntity<Void>> deleteNotParticipatedFeedback( Integer employeeId) {
		return notParticipatedFeedbackRepository.findByemployeeId(employeeId)
				.flatMap(notParticipatedFeedback -> notParticipatedFeedbackRepository.delete(notParticipatedFeedback)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	

	

}
