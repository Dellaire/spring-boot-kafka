package de.clumsystuff.spring_boot_kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ResourceAccessLogger {

	private final static Logger logger = LoggerFactory.getLogger(ResourceAccessLogger.class);
	
	@KafkaListener(topics = "resourceAccess", groupId = "resourceAccess1")
	public void logResourceAccess1(ConsumerRecord<?, String> consumerRecord) {
		
		logger.info("1: " + consumerRecord.value());
	}
	
	@KafkaListener(topics = "resourceAccess", groupId = "resourceAccess2")
	public void logResourceAccess2(ConsumerRecord<?, String> consumerRecord) {
		
		logger.info("2: " + consumerRecord.value());
	}
}
