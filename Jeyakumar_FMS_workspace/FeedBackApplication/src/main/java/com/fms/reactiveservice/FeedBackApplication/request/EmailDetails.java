package com.fms.reactiveservice.FeedBackApplication.request;

import java.util.List;

import com.fms.reactiveservice.FeedBackApplication.entity.FeedbackQuestion;

import lombok.Data;

@Data
public class EmailDetails {
	private String empMailId;
	private String empName;
	private String subject;
	private String message; //title
	private String feedbackType;
	private String eventName;
	private String eventDate;
	private List<FeedbackQuestion> questions;
}
