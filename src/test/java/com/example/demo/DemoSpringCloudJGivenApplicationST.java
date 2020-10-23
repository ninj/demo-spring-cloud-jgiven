package com.example.demo;

import org.junit.jupiter.api.Test;

@SpringBootJGivenTest
class DemoSpringCloudJGivenApplicationST extends SimpleSpringST<HelloStage> {

	@Test
	void contextLoads() {
		then().app_ready();
	}

}
