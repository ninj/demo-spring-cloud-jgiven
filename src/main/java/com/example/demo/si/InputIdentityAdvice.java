package com.example.demo.si;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.messaging.Message;

/**
 * <p>
 * Always returns input message if message is handled successfully.
 * </p>
 * <p>
 * Useful for chaining void methods for service activators in chains.
 * </p>
 * <pre>
 * &lt;int:chain id=&quot;process&quot;
 *            input-channel=&quot;requests&quot;
 *            output-channel=&quot;responses&quot;&gt;
 *     &lt;int:object-to-json-transformer /&gt;
 *     &lt;int:service-activator ref=&quot;messageSender&quot;&gt;
 *         &lt;int:request-handler-advice-chain&gt;
 *             &lt;bean class=&quot;com.example.demo.si.InputIdentityAdvice&quot;/&gt;
 *         &lt;/int:request-handler-advice-chain&gt;
 *     &lt;/int:service-activator&gt;
 *     &lt;int:header-enricher&gt;
 *         &lt;int:header name=&quot;http_statusCode&quot; value=&quot;202&quot;/&gt;
 *     &lt;/int:header-enricher&gt;
 * &lt;/int:chain&gt;
 * </pre>
 */
public class InputIdentityAdvice extends AbstractRequestHandlerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(InputIdentityAdvice.class);

	@Override
	protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) {
		Object result = callback.execute();
		logger.debug("returning input message, instead of result: {}", result);
		return message;
	}

}