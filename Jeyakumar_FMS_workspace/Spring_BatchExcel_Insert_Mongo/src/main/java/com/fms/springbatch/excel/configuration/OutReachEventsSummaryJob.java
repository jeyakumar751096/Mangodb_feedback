package com.fms.springbatch.excel.configuration;

import java.io.File;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import com.fms.springbatch.excel.fileRelocate.EventSummaryFileMoved;
import com.fms.springbatch.excel.fileproperties.OutReachEventSummaryXLFileProperties;
import com.fms.springbatch.excel.model.OutReachEventsSummary;
import com.fms.springbatch.excel.rowMapper.EventsSummaryRowMapper;




@Configuration
@EnableBatchProcessing
public class OutReachEventsSummaryJob {

	Logger log = LoggerFactory.getLogger(OutReachEventsSummaryJob.class);
	
	@Autowired
	@Qualifier("resourceLoaderSummary")
	ResourceLoader resourceLoaderSummary;
	
	@Autowired
	private OutReachEventSummaryXLFileProperties eventSummaryFileProperties;

	// Start Outreach Events Summary
	@Bean
	ItemStreamReader<OutReachEventsSummary> xlsxFileReader2() {
		File file = new File(eventSummaryFileProperties.getFileLocation());
		String absolutePath = file.getAbsolutePath();
		PoiItemReader<OutReachEventsSummary> reader = new PoiItemReader<OutReachEventsSummary>();
		UrlResource resource = (UrlResource) resourceLoaderSummary.getResource("file:\\" + absolutePath);
		log.info("Input file reading..." + resource.getFilename());
		reader.setResource(resource);
		reader.setRowMapper(new EventsSummaryRowMapper());
		reader.setLinesToSkip(1);
		return reader;
	}

	@Bean
	Job jobSummary(JobBuilderFactory jbf, StepBuilderFactory sbf, ItemStreamReader<OutReachEventsSummary> ir,
			ItemWriter<OutReachEventsSummary> iw) {

		Step s1 = (Step) sbf.get("file-2").<OutReachEventsSummary, OutReachEventsSummary>chunk(100).reader(ir)
				.writer(iw).build();

		Step s2 = null;
		try {
			s2 = sbf.get("file2-renamed-moved").tasklet(getFileRenameAndMoveTasketSummary()).build();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return (Job) jbf.get("file2-read").incrementer(new RunIdIncrementer()).start(s1).next(s2).build();
	}

	@Bean
	public EventSummaryFileMoved getFileRenameAndMoveTasketSummary() throws MalformedURLException {
		return new EventSummaryFileMoved();
	};

	// End Outreach Events Summary
}
