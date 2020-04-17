package com.fms.springbatch.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fms.springbatch.excel.*")
public class SpringBatchExcelInsertMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchExcelInsertMongoApplication.class, args);
	}

}
