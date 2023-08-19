package com.xyd.teststudy.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 如果主线程调用线程池中任务的 get() 方法获取结果，主线程会被阻塞等待，直到任务执行完成并返回结果。
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(1);

    // 提交任务到线程池
    Future<Integer> future = executor.submit(() -> {
        // 模拟耗时操作
        Thread.sleep(10000);
        return 42;
    });

        System.out.println("Main thread is doing something...");

        try {
        // 主线程调用get()方法，阻塞等待任务执行结果
        Integer result = future.get();
        System.out.println("Task result: " + result);
    } catch (Exception e) {
        e.printStackTrace();
    }

        System.out.println("Main thread continues execution...");

    // 关闭线程池
        executor.shutdown();
}
}
