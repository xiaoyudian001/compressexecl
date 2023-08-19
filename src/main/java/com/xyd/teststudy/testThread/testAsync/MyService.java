package com.xyd.teststudy.testThread.testAsync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class MyService {
    @Async
    public CompletableFuture<String> asyncMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 中断时的处理逻辑
            System.out.println("Sleep interrupted!");
            Thread.currentThread().interrupt(); // 重新设置中断状态
        }
        return CompletableFuture.completedFuture("Async method result");
    }
}
