package com.fms.reactiveservice.FeedBackApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.reactiveservice.FeedBackApplication.repositories.ParticipatedFeedbackRepository;

@Service
public class ParticipatedFeedbackService {
	
	@Autowired
	public ParticipatedFeedbackRepository participatedFeedbackRepository;

}
