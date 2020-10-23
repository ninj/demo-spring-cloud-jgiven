package com.example.demo.qz;

import com.example.demo.HelloStage;
import com.example.demo.SimpleSpringST;
import com.example.demo.SpringBootJGivenTest;
import org.junit.jupiter.api.Test;

@SpringBootJGivenTest
public class QuartzST extends SimpleSpringST<HelloStage> {

	@Test
	void scheduler_can_be_obtained() {
		given().scheduler();
		then().scheduler_ok();
	}

}
