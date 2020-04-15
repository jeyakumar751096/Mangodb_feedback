package com.fms.reactiveservice.FeedBackApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.reactiveservice.FeedBackApplication.Service.ParticipatedFeedbackService;

@RestController
@RequestMapping("/email/Participated")
public class ParticipatedFeedbackController {
	
	@Autowired
	public ParticipatedFeedbackService participatedFeedbackService;

}
