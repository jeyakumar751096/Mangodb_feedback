package com.fms.mongo.SpringMailFms.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.reactive.result.view.freemarker.FreeMarkerConfigurer;

import com.fms.mongo.SpringMailFms.property.FMSMailConfigProperties;

@Configuration
public class FMSMailConfiguration {

	
	@Autowired
	//@Qualifier("propertieMail")
	private FMSMailConfigProperties propertieMail;

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		mailSender.setHost(propertieMail.getHost());
		mailSender.setPort(propertieMail.getPort());
		mailSender.setUsername(propertieMail.getFromMailId());
		mailSender.setPassword(propertieMail.getFromMailIdPassword());
		
		Properties javaMailProp=new Properties();
		javaMailProp.put(propertieMail.getSmtpStarttls(),true);
		javaMailProp.put(propertieMail.getSmtpAuth(), true);
		javaMailProp.put(propertieMail.getSmtpTransProtocal(),"smtp");
		javaMailProp.put(propertieMail.getDebug(), true );
		mailSender.setJavaMailProperties(javaMailProp);
		return mailSender;
	}
	
	@Bean
	public FreeMarkerConfigurer getfreeMarkerConfig() {
		FreeMarkerConfigurer freemakerBean=new FreeMarkerConfigurer();
		freemakerBean.setTemplateLoaderPath("classpath:/fmsMailTemplate");
		freemakerBean.setDefaultEncoding("UTF-8");
		return freemakerBean;
	}
}
