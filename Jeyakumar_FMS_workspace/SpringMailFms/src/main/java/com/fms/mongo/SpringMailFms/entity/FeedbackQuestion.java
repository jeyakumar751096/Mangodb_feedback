package com.fms.mongo.SpringMailFms.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class FeedbackQuestion {
	
	@Id
	private Integer questionId;
	private String question;
	private String feedbackType;
	private String questionType;
	private List<FeedbackQuestionAnswer> feedbackQuestionAnswer;

}
