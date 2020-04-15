package com.fms.reactiveservice.FeedBackApplication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Document
public class FeedbackQuestionAnswer {

	@Id
	private Integer answerId;
	private Integer questionId;
	private String answers;
	private String eventID;

}
