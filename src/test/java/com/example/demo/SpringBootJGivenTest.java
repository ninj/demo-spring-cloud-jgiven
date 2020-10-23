package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(classes = TestConfig.class, webEnvironment = RANDOM_PORT)
public @interface SpringBootJGivenTest {

}
