package com.example.demo;

import com.google.api.gax.rpc.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.PubSubAdmin;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageHandler;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource("/integration/integration.xml")
public class DemoSpringCloudJGivenApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringCloudJGivenApplication.class, args);
	}

	@Bean
	public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
		PubSubMessageHandler messageHandler = new PubSubMessageHandler(pubsubTemplate, "topicName");
		messageHandler.setSync(true);
		return messageHandler;
	}

	@Autowired
	PubSubAdmin pubSubAdmin;

	@PostConstruct
	public void init() {
		try {
//			pubSubAdmin.createTopic("topicName");
		}
		catch (AlreadyExistsException ex) {
			// ignored
		}
	}

}
