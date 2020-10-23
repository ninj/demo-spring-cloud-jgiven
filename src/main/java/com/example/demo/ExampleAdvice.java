package com.example.demo;

import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ExampleAdvice extends AbstractRequestHandlerAdvice {

    @Override
    protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) {
        Object result = callback.execute();
        return message;
    }
}