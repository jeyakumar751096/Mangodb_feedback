package com.fms.springbatch.excel.dbWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fms.springbatch.excel.model.OutReachEventsSummary;
import com.fms.springbatch.excel.repository.OutReachEventsSummaryRepository;



@Component
public class OutReachEventsSummaryWriter implements ItemWriter<OutReachEventsSummary> {

	@Autowired
	OutReachEventsSummaryRepository eventSummaryRepo;

	@Override
	public void write(List<? extends OutReachEventsSummary> eventSummary) throws Exception {
		eventSummaryRepo.saveAll(eventSummary);
	}

}
