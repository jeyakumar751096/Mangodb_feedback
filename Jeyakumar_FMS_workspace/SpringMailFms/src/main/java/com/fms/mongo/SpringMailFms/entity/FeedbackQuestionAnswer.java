package com.fms.mongo.SpringMailFms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class FeedbackQuestionAnswer {

	@Id
	private Integer answerId;
	private Integer questionId;
	private String answers;
	private String eventID;

}
