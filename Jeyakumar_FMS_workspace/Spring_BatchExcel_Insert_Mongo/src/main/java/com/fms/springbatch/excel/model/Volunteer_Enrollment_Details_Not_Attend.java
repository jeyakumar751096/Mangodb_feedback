package com.fms.springbatch.excel.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document( value = "volunteerenrollmentdetail_notattend")
@Data

public class Volunteer_Enrollment_Details_Not_Attend implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger enrollnotattendId;
	private String eventId;
	private String eventName;
	private String beneficiaryName;
	private String baseLocation;
	private Date eventDate; //(DD-MM-YY)
	private String employeeId;
}
