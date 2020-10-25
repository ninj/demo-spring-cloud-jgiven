package com.example.demo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

@JGivenStage
public class HelloStage extends Stage<HelloStage> {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SchedulerFactoryBean factoryBean;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Autowired
	MessageHandler messageSender;

	@Value("http://localhost:${local.server.port}/hello")
	String url;

	@ProvidedScenarioState
	private Scheduler scheduler;

	private ResponseEntity<Void> responseEntity;

	public void app_ready() {
		assertThat(applicationContext).isNotNull();
	}

	public void scheduler() {
		scheduler = factoryBean.getScheduler();
	}

	public void scheduler_ok() {
		assertThat(scheduler).isNotNull();
	}

	public void webhook_request_sent() {
		responseEntity = testRestTemplate.postForEntity(url, "request", Void.class);
	}

	public HelloStage webhook_response_accepted() {
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
		return this;
	}

	public HelloStage webhook_payload_published_to_pubsub() {
		verify(messageSender).handleMessage(any());
		return this;
	}

}
