package de.clumsystuff.spring_boot_kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ResourceAccessLogger {

	private final static Logger logger = LoggerFactory.getLogger(ResourceAccessLogger.class);
	
	@KafkaListener(topics = "resourceAccess")
	public void logResourceAccess(ConsumerRecord<?, String> consumerRecord) {
		
		logger.info(consumerRecord.value());
	}
}
