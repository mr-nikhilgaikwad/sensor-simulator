package com.nikhil.dataproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikhil.dataproducer.constants.SampleData;
import com.nikhil.dataproducer.service.ProducerService;

@SpringBootApplication
public class DataProducerApplication implements CommandLineRunner{
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	SampleData sampleData;
	
	@Value("${kafka.topic.name}")
	private String topicName;

	public static void main(String[] args) {
		SpringApplication.run(DataProducerApplication.class, args);
		System.out.println("Producer started...");
	}

	@Override
	public void run(String... args) throws Exception {
		var data = sampleData.getSample();
		producerService.sendMessage(topicName, data.getPointId(), objectMapper.writeValueAsString(data));
	}

}
