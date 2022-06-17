package com.AnimalFactsChatmentAssignment.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AnimalFactsChatmentAssignment.api.dao.RecordRepository;

@Component
public class RecordService {
	
	@Autowired
	RecordRepository recordRepository;
	
	public void save(com.AnimalFactsChatmentAssignment.api.model.Record record) {
		recordRepository.save(record);
	}
	
	public List<com.AnimalFactsChatmentAssignment.api.model.Record> getAllRecords() {
		return recordRepository.findAll();
	}

}
