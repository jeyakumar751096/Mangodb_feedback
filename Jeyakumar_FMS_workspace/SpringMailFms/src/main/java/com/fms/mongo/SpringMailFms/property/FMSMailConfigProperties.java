package com.fms.mongo.SpringMailFms.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@ConfigurationProperties("fms.mail")
public class FMSMailConfigProperties {

	private String host;
	private Integer port;
	private String fromMailId;
	private String fromMailIdPassword;
	private String smtpStarttls;
	private String smtpAuth;
	private String smtpTransProtocal;
	private String debug;
}
