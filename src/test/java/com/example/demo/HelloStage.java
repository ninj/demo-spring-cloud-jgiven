package com.example.demo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@JGivenStage
class HelloStage extends Stage<HelloStage> {

	@Autowired
	ApplicationContext applicationContext;

	public void app_ready() {
		assertThat(applicationContext).isNotNull();
	}

}
