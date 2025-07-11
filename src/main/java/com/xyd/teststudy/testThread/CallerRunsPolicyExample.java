package com.xyd.teststudy.testThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallerRunsPolicyExample {
    public static void main(String[] args) {
        // 创建一个线程池，设置核心线程数为2，最大线程数为4，
        // 使用有界队列，队列大小为2，并设置拒绝策略为CallerRunsPolicy
        System.out.println("======开始======");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                8, // 核心线程数
                16, // 最大线程数
                0, // 线程空闲时间
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(2), // 有界队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略
        );

        // 提交6个任务
        for (int i = 1; i <= 1000000000; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName());
            });
        }
        System.out.println("======结束======");
        // 关闭线程池
        executor.shutdown();
    }
}
