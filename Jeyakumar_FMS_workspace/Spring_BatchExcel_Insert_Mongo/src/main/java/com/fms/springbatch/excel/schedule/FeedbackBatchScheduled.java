package com.fms.springbatch.excel.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class FeedbackBatchScheduled {
	
private static final Logger log = LoggerFactory.getLogger(FeedbackBatchScheduled.class);
	
	@Autowired
	JobLauncher jobLuncher;
	
	@Autowired
	Job jobInformation;
	
	@Autowired
	Job jobSummary;
	
	@Autowired
	Job jobUnregistered;
	
	@Autowired
	Job jobNotAttend;
	
	@Scheduled(cron="* */5 * * * ?")
	public void perform()throws Exception {
		JobParameters param=new JobParametersBuilder()
				.addString("EventInformation-Job", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		try {
			log.info("OutReachEventInformationJob Launch");
			JobExecution eventInfo_Job=jobLuncher.run(jobInformation, param);
			log.info("OutReachEventInformationJob Launch status :::"+eventInfo_Job.getExitStatus());
			
			log.info("OutReachEventsSummaryJob Launch");
			JobExecution eventSummary_Job = jobLuncher.run(jobSummary, param);
			log.info("OutReachEventsSummaryJob Launch status :::" + eventSummary_Job.getExitStatus());
			
			log.info("VolunteerEnrollDetailNotAttendJob Launch");
			JobExecution notAttend_Job = jobLuncher.run(jobNotAttend, param);
			log.info("VolunteerEnrollDetailNotAttendJob Launch status :::" + notAttend_Job.getExitStatus());

			log.info("VolunteerEnrollDetailUnregisteredJob Launch");
			JobExecution unRegistered_Job = jobLuncher.run(jobUnregistered, param);
			log.info("VolunteerEnrollDetailUnregisteredJob Launch status :::" + unRegistered_Job.getExitStatus());
		  
		}catch(JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
			log.error("JobLauncher exception ::"+ e.getMessage());
		}
	}
	
	

}
