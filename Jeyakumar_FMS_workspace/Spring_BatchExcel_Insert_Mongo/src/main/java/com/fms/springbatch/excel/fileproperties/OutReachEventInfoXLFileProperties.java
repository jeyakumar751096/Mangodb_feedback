package com.fms.springbatch.excel.fileproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@ConfigurationProperties("event.information")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OutReachEventInfoXLFileProperties {
	
	private String fileLocation;
	private String outputFileLocation;
	private Boolean shouldMoveFile;

}