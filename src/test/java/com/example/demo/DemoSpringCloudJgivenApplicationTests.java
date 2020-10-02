package com.example.demo;

import com.tngtech.jgiven.integration.spring.junit5.SimpleSpringScenarioTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestConfig.class)
class DemoSpringCloudJgivenApplicationTests extends SimpleSpringScenarioTest<HelloStage> {

    @Test
    void contextLoads() {
        then().app_ready();
    }

}
