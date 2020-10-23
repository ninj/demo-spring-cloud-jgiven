# PubSub Emulator

## Stacktraces

### No Topic

```
2020-10-22 21:58:54.826  WARN 10625 --- [ault-executor-0] o.s.c.g.p.c.p.PubSubPublisherTemplate    : Publishing to topicName topic failed.

com.google.api.gax.rpc.NotFoundException: io.grpc.StatusRuntimeException: NOT_FOUND: Topic not found
	at com.google.api.gax.rpc.ApiExceptionFactory.createException(ApiExceptionFactory.java:45) ~[gax-1.57.1.jar:1.57.1]
	at com.google.api.gax.grpc.GrpcApiExceptionFactory.create(GrpcApiExceptionFactory.java:72) ~[gax-grpc-1.57.1.jar:1.57.1]
	at com.google.api.gax.grpc.GrpcApiExceptionFactory.create(GrpcApiExceptionFactory.java:60) ~[gax-grpc-1.57.1.jar:1.57.1]
	at com.google.api.gax.grpc.GrpcExceptionCallable$ExceptionTransformingFuture.onFailure(GrpcExceptionCallable.java:97) ~[gax-grpc-1.57.1.jar:1.57.1]
	at com.google.api.core.ApiFutures$1.onFailure(ApiFutures.java:68) ~[api-common-1.9.3.jar:na]
	at com.google.common.util.concurrent.Futures$CallbackListener.run(Futures.java:1083) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.DirectExecutor.execute(DirectExecutor.java:30) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.AbstractFuture.executeListener(AbstractFuture.java:1174) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.AbstractFuture.complete(AbstractFuture.java:969) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.AbstractFuture.setException(AbstractFuture.java:760) ~[guava-29.0-jre.jar:na]
	at io.grpc.stub.ClientCalls$GrpcFuture.setException(ClientCalls.java:545) ~[grpc-stub-1.30.2.jar:1.30.2]
	at io.grpc.stub.ClientCalls$UnaryStreamToFuture.onClose(ClientCalls.java:515) ~[grpc-stub-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl.closeObserver(ClientCallImpl.java:426) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl.access$500(ClientCallImpl.java:66) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl.close(ClientCallImpl.java:689) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl.access$900(ClientCallImpl.java:577) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInternal(ClientCallImpl.java:751) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInContext(ClientCallImpl.java:740) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:123) ~[grpc-core-1.30.2.jar:1.30.2]
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630) ~[na:na]
	at java.base/java.lang.Thread.run(Thread.java:851) ~[na:na]
Caused by: io.grpc.StatusRuntimeException: NOT_FOUND: Topic not found
	at io.grpc.StatusRuntimeException.fillInStackTrace(StatusRuntimeException.java:68) ~[grpc-api-1.30.2.jar:1.30.2]
	at io.grpc.StatusRuntimeException.<init>(StatusRuntimeException.java:58) ~[grpc-api-1.30.2.jar:1.30.2]
	at io.grpc.StatusRuntimeException.<init>(StatusRuntimeException.java:50) ~[grpc-api-1.30.2.jar:1.30.2]
	at io.grpc.Status.asRuntimeException(Status.java:533) ~[grpc-api-1.30.2.jar:1.30.2]
	... 12 common frames omitted
```

### Unable To Resolve Credentials
```
2020-10-22 23:06:53.834  WARN 11425 --- [bsub-publisher4] o.s.c.g.p.c.p.PubSubPublisherTemplate    : Publishing to topicName topic failed.

com.google.api.gax.rpc.UnavailableException: io.grpc.StatusRuntimeException: UNAVAILABLE: Credentials failed to obtain metadata
	at com.google.api.gax.rpc.ApiExceptionFactory.createException(ApiExceptionFactory.java:69) ~[gax-1.57.1.jar:1.57.1]
	at com.google.api.gax.grpc.GrpcApiExceptionFactory.create(GrpcApiExceptionFactory.java:72) ~[gax-grpc-1.57.1.jar:1.57.1]
	at com.google.api.gax.grpc.GrpcApiExceptionFactory.create(GrpcApiExceptionFactory.java:60) ~[gax-grpc-1.57.1.jar:1.57.1]
	at com.google.api.gax.grpc.GrpcExceptionCallable$ExceptionTransformingFuture.onFailure(GrpcExceptionCallable.java:97) ~[gax-grpc-1.57.1.jar:1.57.1]
	at com.google.api.core.ApiFutures$1.onFailure(ApiFutures.java:68) ~[api-common-1.9.3.jar:na]
	at com.google.common.util.concurrent.Futures$CallbackListener.run(Futures.java:1083) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.DirectExecutor.execute(DirectExecutor.java:30) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.AbstractFuture.executeListener(AbstractFuture.java:1174) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.AbstractFuture.complete(AbstractFuture.java:969) ~[guava-29.0-jre.jar:na]
	at com.google.common.util.concurrent.AbstractFuture.setException(AbstractFuture.java:760) ~[guava-29.0-jre.jar:na]
	at io.grpc.stub.ClientCalls$GrpcFuture.setException(ClientCalls.java:545) ~[grpc-stub-1.30.2.jar:1.30.2]
	at io.grpc.stub.ClientCalls$UnaryStreamToFuture.onClose(ClientCalls.java:515) ~[grpc-stub-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl.closeObserver(ClientCallImpl.java:426) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl.access$500(ClientCallImpl.java:66) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl.close(ClientCallImpl.java:689) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl.access$900(ClientCallImpl.java:577) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInternal(ClientCallImpl.java:751) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInContext(ClientCallImpl.java:740) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37) ~[grpc-core-1.30.2.jar:1.30.2]
	at io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:123) ~[grpc-core-1.30.2.jar:1.30.2]
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515) ~[na:na]
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264) ~[na:na]
	at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630) ~[na:na]
	at java.base/java.lang.Thread.run(Thread.java:851) ~[na:na]
Caused by: io.grpc.StatusRuntimeException: UNAVAILABLE: Credentials failed to obtain metadata
	at io.grpc.StatusRuntimeException.fillInStackTrace(StatusRuntimeException.java:68) ~[grpc-api-1.30.2.jar:1.30.2]
	at io.grpc.StatusRuntimeException.<init>(StatusRuntimeException.java:58) ~[grpc-api-1.30.2.jar:1.30.2]
	at io.grpc.StatusRuntimeException.<init>(StatusRuntimeException.java:50) ~[grpc-api-1.30.2.jar:1.30.2]
	at io.grpc.Status.asRuntimeException(Status.java:533) ~[grpc-api-1.30.2.jar:1.30.2]
	... 15 common frames omitted
```