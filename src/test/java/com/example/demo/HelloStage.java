package com.example.demo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.assertj.core.api.Assertions.assertThat;

@JGivenStage
public class HelloStage extends Stage<HelloStage> {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SchedulerFactoryBean factoryBean;

	@ProvidedScenarioState
	private Scheduler scheduler;

	public void app_ready() {
		assertThat(applicationContext).isNotNull();
	}

	public void scheduler() {
		scheduler = factoryBean.getScheduler();
	}

	public void scheduler_ok() {
		assertThat(scheduler).isNotNull();
	}

}
