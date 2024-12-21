package com.nikhil.dataproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(String topic, String key, String topicName) {
		kafkaTemplate.send(topic, key, topicName);
	}
}
