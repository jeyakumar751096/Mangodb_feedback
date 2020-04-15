package com.fms.reactiveservice.FeedBackApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.reactiveservice.FeedBackApplication.Service.NotParticipatedFeedbackService;

@RestController
@RequestMapping("/email/NotParticipat")
public class NotParticipatedFeedbackController {
	
	@Autowired
	public NotParticipatedFeedbackService notParticipatedFeedbackService;

}
