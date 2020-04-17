package com.fms.springbatch.excel.fileproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("volunteer.enroll.unregistered")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VolunteerUnregisteredXLFileProperties {

	private String fileLocation;
	private String outputFileLocation;
	private Boolean shouldMoveFile;

	
}