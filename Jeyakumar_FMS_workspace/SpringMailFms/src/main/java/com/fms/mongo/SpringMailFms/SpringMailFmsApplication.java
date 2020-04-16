package com.fms.mongo.SpringMailFms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fms.mongo.SpringMailFms.*")
public class SpringMailFmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMailFmsApplication.class, args);
	}

}
