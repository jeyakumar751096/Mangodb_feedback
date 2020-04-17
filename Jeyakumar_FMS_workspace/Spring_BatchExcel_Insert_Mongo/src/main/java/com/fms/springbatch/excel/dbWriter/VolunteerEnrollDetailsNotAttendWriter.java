package com.fms.springbatch.excel.dbWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fms.springbatch.excel.model.Volunteer_Enrollment_Details_Not_Attend;
import com.fms.springbatch.excel.repository.VolunteerEnrollDtlsNotAttendRepo;



@Component
public class VolunteerEnrollDetailsNotAttendWriter implements ItemWriter<Volunteer_Enrollment_Details_Not_Attend> {

	@Autowired
	VolunteerEnrollDtlsNotAttendRepo volunteerEnrollNotAttendRepo;

	@Override
	public void write(List<? extends Volunteer_Enrollment_Details_Not_Attend> notAttend) throws Exception {
		volunteerEnrollNotAttendRepo.saveAll(notAttend);
	}

}
