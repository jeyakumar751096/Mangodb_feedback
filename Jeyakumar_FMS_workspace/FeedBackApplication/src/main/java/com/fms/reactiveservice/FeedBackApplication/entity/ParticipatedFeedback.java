package com.fms.reactiveservice.FeedBackApplication.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ParticipatedFeedback implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer participateId;
	private Integer employeeId;
	private Integer eventId;
	private Integer rating;
	private String activityLike;
	private String activityImproved;

}
