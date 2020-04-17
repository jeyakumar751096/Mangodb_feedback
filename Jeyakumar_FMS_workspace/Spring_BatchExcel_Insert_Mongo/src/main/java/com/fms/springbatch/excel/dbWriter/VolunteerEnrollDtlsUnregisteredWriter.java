package com.fms.springbatch.excel.dbWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fms.springbatch.excel.model.Volunteer_Enrollment_Details_Unregistered;
import com.fms.springbatch.excel.repository.VolunteerEnrollDtlsUnregisteredRepo;



@Component
public class VolunteerEnrollDtlsUnregisteredWriter implements ItemWriter<Volunteer_Enrollment_Details_Unregistered> {

	@Autowired
	VolunteerEnrollDtlsUnregisteredRepo VolunteerEnrollDtlsUnregRepo;

	@Override
	public void write(List<? extends Volunteer_Enrollment_Details_Unregistered> unRegistered) throws Exception {
		VolunteerEnrollDtlsUnregRepo.saveAll(unRegistered);
	}

}
