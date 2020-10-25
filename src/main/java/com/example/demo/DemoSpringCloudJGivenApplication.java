package com.example.demo;

import com.google.api.gax.rpc.AlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DemoSpringCloudJGivenApplication.class);
    private final PubSubAdmin pubSubAdmin;

    @Autowired
    public DemoSpringCloudJGivenApplication(PubSubAdmin pubSubAdmin) {
        this.pubSubAdmin = pubSubAdmin;
    }

    public static void main(String[] args) {
		SpringApplication.run(DemoSpringCloudJGivenApplication.class, args);
	}

	@Bean
	public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
		PubSubMessageHandler messageHandler = new PubSubMessageHandler(pubsubTemplate, "topicName");
		messageHandler.setSync(true);
		return messageHandler;
	}

	@PostConstruct
	public void init() {
		try {
			 pubSubAdmin.createTopic("topicName");
			 logger.info("topic created: topicName");
		}
		catch (AlreadyExistsException ex) {
			logger.info("topic already exists: topicName");
		}
	}

}
