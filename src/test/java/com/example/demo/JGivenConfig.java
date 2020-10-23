package com.example.demo;

import com.tngtech.jgiven.config.AbstractJGivenConfiguration;

public class JGivenConfig extends AbstractJGivenConfiguration {

	@Override
	public void configure() {
		setTestClassSuffixRegEx("ST");
	}

}
