package com.example.demo.qz;

import com.example.demo.HelloStage;
import com.example.demo.SpringBootJGivenTest;
import com.tngtech.jgiven.integration.spring.junit5.SimpleSpringScenarioTest;
import org.junit.jupiter.api.Test;

@SpringBootJGivenTest
public class QuartzTest extends SimpleSpringScenarioTest<HelloStage> {

	@Test
	void scheduler_can_be_obtained() {
		given().scheduler();
		then().scheduler_ok();
	}

}
