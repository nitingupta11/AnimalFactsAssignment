package com.AnimalFactsChatmentAssignment.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AnimalFactsChatmentAssignment.api.Exceptions.AnimalNotSupportedException;
import com.AnimalFactsChatmentAssignment.api.Exceptions.MethodNotSupportedException;
import com.AnimalFactsChatmentAssignment.api.data.AnimalFact;
import com.AnimalFactsChatmentAssignment.api.data.Animals;
import com.AnimalFactsChatmentAssignment.api.service.FactService;
import com.AnimalFactsChatmentAssignment.api.service.RecordService;

@RestController
@RequestMapping("/api/v2")
public class FactController {
	
	@Autowired
	private FactService factService;
	
	@Autowired
	private RecordService recordService;
	
	
	@GetMapping("/animalFact")
	public ResponseEntity<AnimalFact> getFact(@RequestParam("animalType") Animals animalType, HttpServletRequest request) throws AnimalNotSupportedException, MethodNotSupportedException{
		AnimalFact animalFact = factService.getFact(animalType, request);
		return new ResponseEntity<>(animalFact, HttpStatus.OK);
	}
	
	@GetMapping("/getAllRecords")
	public ResponseEntity<List<com.AnimalFactsChatmentAssignment.api.model.Record>> getAllRecords() {
		return new ResponseEntity<>(recordService.getAllRecords(), HttpStatus.OK);
	}
	
}
	
