package com.fms.springbatch.excel.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fms.springbatch.excel.model.Volunteer_Enrollment_Details_Unregistered;


public interface VolunteerEnrollDtlsUnregisteredRepo  extends MongoRepository<Volunteer_Enrollment_Details_Unregistered, BigInteger>{

}
