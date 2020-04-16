package com.fms.mongo.SpringMailFms.service;

import com.fms.mongo.SpringMailFms.entity.EmailDetails;

public interface FMSMailService {
	
	public void sendMail( final String receiverEmailId, final String Subject,
			final String message,EmailDetails mail);

}
