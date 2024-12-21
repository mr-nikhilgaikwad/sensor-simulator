package com.nikhil.dataproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class PConfig {
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value("${spring.kafka.producer.key-serializer}")
	private String keySerializer;
	
	@Value("${spring.kafka.producer.value-serializer}")
	private String valueSerializer;
	
	@Value("${spring.kafka.producer.acks}")
	private String acks;
	
	@Value("${spring.kafka.producer.compression-type}")
	private String compressionType;
	
	@Value("${spring.kafka.producer.batch-size}")
	private String batchSize;
	
	@Value("${spring.kafka.producer.linger-ms}")
	private String lingerMs;
	
	@Value("${spring.kafka.producer.buffer-memory}")
	private String bufferMemory;
	
	@Value("${spring.kafka.producer.max-request-size}")
	private String maxRequestSize;
	
	@Value("${spring.kafka.producer.request-timeout-ms}")
	private String requestTimeoutMs;
	
	@Value("${spring.kafka.producer.max-block-ms}")
	private String maxBlockMs;
	
	@Bean
	public ProducerFactory<String, Object> producerFactory(){
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
		configProps.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, compressionType);
		configProps.put(ProducerConfig.ACKS_CONFIG, acks);  
		
		configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize); 
		configProps.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs); 
		configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);  
		configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSize); 
		configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeoutMs); 
		configProps.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, maxBlockMs);
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
