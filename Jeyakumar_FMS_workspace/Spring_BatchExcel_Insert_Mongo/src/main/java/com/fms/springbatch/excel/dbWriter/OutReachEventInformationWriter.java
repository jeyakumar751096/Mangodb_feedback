package com.fms.springbatch.excel.dbWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fms.springbatch.excel.model.OutReachEventInformation;
import com.fms.springbatch.excel.repository.OutReachEventInformationRepository;

@Component
public class OutReachEventInformationWriter implements ItemWriter<OutReachEventInformation> {

	@Autowired
	OutReachEventInformationRepository eventInfoRepository;

	@Override
	public void write(List<? extends OutReachEventInformation> eventInformations) throws Exception {
		eventInfoRepository.saveAll(eventInformations);
	}
}
