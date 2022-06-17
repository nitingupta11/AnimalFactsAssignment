package com.AnimalFactsChatmentAssignment.api.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.AnimalFactsChatmentAssignment.api.Exceptions.AnimalNotSupportedException;
import com.AnimalFactsChatmentAssignment.api.Exceptions.MethodNotSupportedException;
import com.AnimalFactsChatmentAssignment.api.data.AnimalFact;
import com.AnimalFactsChatmentAssignment.api.data.Animals;

@Component
public class FactService {
	
	@Value("${animals.fact.url}")
	private String animalFactUrl;
	
	@Value("${animals.fact.url.method}")
	private String animalFactMethod;
	
	@Autowired
	RecordService recordService;
	
	@Autowired
	IpAddressService ipAddressService;
	
	public AnimalFact getFact(Animals type, HttpServletRequest request) throws AnimalNotSupportedException, MethodNotSupportedException {
		
		if(type == null) 
			throw new AnimalNotSupportedException("This Animal type is not supported");
		
		RestTemplate restTemplate = new RestTemplate();
		AnimalFact animalFact = null;
		
		String finalUrl = 
				UriComponentsBuilder
				.fromHttpUrl(animalFactUrl)
				.queryParam("animal_type", type.toString().toLowerCase())
				.encode()
				.toUriString();
		switch(animalFactMethod) {
			case "GET":
				animalFact = restTemplate.getForObject(finalUrl, AnimalFact.class);
				com.AnimalFactsChatmentAssignment.api.model.Record record = new com.AnimalFactsChatmentAssignment.api.model.Record(ipAddressService.getClientIp(request), animalFact.getText());
				recordService.save(record);
				break;
			default:
				throw new MethodNotSupportedException(String.format("The method %s is not supported", animalFactMethod));
		}
		return animalFact;
	}

}
