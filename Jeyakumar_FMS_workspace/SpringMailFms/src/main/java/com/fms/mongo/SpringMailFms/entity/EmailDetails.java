package com.fms.mongo.SpringMailFms.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EmailDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empMailId;
	private String empName;
	private String subject;
	private String message; //title
	private String feedbackType;
	private String eventName;
	private String eventDate;
	private List<FeedbackQuestion> questions;
}
