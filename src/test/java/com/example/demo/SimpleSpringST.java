package com.example.demo;

import com.tngtech.jgiven.annotation.JGivenConfiguration;
import com.tngtech.jgiven.integration.spring.junit5.SimpleSpringScenarioTest;

/**
 * Common base class for Scenario Tests with common JGiven configuration
 *
 * @param <STAGE> the stage class
 */
@JGivenConfiguration(JGivenConfig.class)
public class SimpleSpringST<STAGE> extends SimpleSpringScenarioTest<STAGE> {

}
