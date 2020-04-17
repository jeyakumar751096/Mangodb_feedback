package com.fms.springbatch.excel.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "OutReachEventsSummary")
@Data

public class OutReachEventsSummary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger OutreachEventsSummaryId;
	private String eventID;
	private String months;
	private String baseLocation;
	private String beneficiaryName;
	private String venueAddress;
	private String councilName;
	private String project;
	private String category;
	private String eventName;
	private String eventDescription;
	private Date eventDate; // (DD-MM-YY)
	private String totalNoOfVolunteers;
	private String totalVolunteerHours;
	private String totalTravelHours;
	private String overallVolunteeringHours;
	private String livesImpacted;
	private String activityType;
	private String status;
	private String pocId;
	private String pocName;
	private String pocContactNumber;

}
