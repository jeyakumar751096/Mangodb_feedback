package com.fms.reactiveservice.FeedBackApplication.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class UnRegisteredFeedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer unRegisteredId;
	private Integer employeeId;
	private Integer eventId;
	private Integer questionId;
	private Integer answerId;
	private String eventName;	
	private String beneficiaryName;
	private String baseLocation;
}
