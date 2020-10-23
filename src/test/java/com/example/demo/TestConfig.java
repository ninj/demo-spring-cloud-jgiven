package com.example.demo;

import com.tngtech.jgiven.integration.spring.EnableJGiven;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.gcp.pubsub.PubSubAdmin;
import org.springframework.messaging.MessageHandler;

@TestConfiguration
@EnableJGiven
class TestConfig {

    @SuppressWarnings("unused")
    @MockBean
	private PubSubAdmin pubsubAdmin;

    @SuppressWarnings("unused")
    @MockBean(name = "messageSender")
	private MessageHandler messageSender;
}
