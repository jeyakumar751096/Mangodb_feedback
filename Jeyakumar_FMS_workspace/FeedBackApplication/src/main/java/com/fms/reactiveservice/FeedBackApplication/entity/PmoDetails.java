package com.fms.reactiveservice.FeedBackApplication.entity;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document

public class PmoDetails {
	
	@Id
	private Integer empRoleId;
	private Integer employeeId;
	private String empFirstName;
	private String empLastName;
	private String empEmailId;
	private String empRole;

}
