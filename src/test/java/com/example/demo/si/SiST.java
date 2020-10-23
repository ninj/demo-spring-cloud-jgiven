package com.example.demo.si;

import com.example.demo.HelloStage;
import com.example.demo.SimpleSpringST;
import com.example.demo.SpringBootJGivenTest;
import org.junit.jupiter.api.Test;

@SpringBootJGivenTest
public class SiST extends SimpleSpringST<HelloStage> {

	@Test
	void webhook_accepted_and_published() {
		when().webhook_request_sent();
		then().webhook_response_accepted().and().webhook_payload_published_to_pubsub();
	}

}
