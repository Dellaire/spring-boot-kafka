package de.clumsystuff.spring_boot_kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourceController {

	@Autowired
	private KafkaTemplate<String, String> template;

	@GetMapping("/{resourceId}")
	public void triggerEvent(@PathVariable String resourceId) {

		this.template.send("resourceAccess", "Resource with ID " + resourceId + " was requested");
	}
}
