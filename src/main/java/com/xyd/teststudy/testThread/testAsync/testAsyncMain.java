package com.xyd.teststudy.testThread.testAsync;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class testAsyncMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);

        CompletableFuture<String> future = myService.asyncMethod();
        System.out.println("Main thread continues execution...");

        future.whenComplete((result, error) -> {
            if (error != null) {
                error.printStackTrace();
            } else {
                System.out.println("Async method result: " + result);
            }
        });
        // 等待异步任务执行完成
        Thread.sleep(3000);

        context.close();
    }
}
