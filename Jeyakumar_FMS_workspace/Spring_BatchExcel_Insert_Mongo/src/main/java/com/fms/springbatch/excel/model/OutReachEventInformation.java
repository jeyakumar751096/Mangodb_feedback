package com.fms.springbatch.excel.model;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "OutReachEventInformation")
@Data
public class OutReachEventInformation {
	
	@Id
	private BigInteger outReachEventInformId;
	private String eventID;
	private String baseLocation;
	private String beneficiaryName;
	private String councilName;
	private String eventName;
	private String eventDescription;
	private Date eventDate;
	private String employeeID;
	private String employeeName;
	private Double volunteerHours;
	private Double travelHours;
	private Double livesImpacted;
	private String businessUnit;
	private String status;
	private String iiepCategory;

}
