package com.fms.mongo.SpringMailFms.entity;

import java.util.List;

import lombok.Data;

@Data
public class MailRequest {
	
	private List<EmailDetails> emailDetails;

}
