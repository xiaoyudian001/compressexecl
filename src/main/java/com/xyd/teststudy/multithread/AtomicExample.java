package com.xyd.teststudy.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        // 启动10个线程，每个线程对value进行自增操作
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    incrementValue();
                }
            }).start();
        }

        // 等待所有线程执行完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value: " + value);
    }

    private static void incrementValue() {
        System.out.println("当前线程名："+Thread.currentThread());
        int current;
        int next;
        do {
            // 获取当前值
            current = value.get();
            // 计算下一个值
            next = current + 1;
        } while (!value.compareAndSet(current, next));
    }
}
/**
 * 在上述示例中，我们创建了一个名为value的AtomicInteger变量，并初始化为0。
 * 然后创建了10个线程，并使用compareAndSet方法对value进行自增操作。每个线程都会循环执行1000次自增操作。
 *
 * 在自增操作中，我们首先获取当前的值current，然后计算出下一个值next。
 * 接下来使用compareAndSet方法比较当前值和期望值，如果相等则将value的值设置为next。
 * 如果比较失败，则说明有其他线程修改了value的值，需要重新获取当前值并计算下一个值，直到成功设置值为止。
 *
 * 最后，等待所有线程执行完成后，打印出最终的value的值。由于compareAndSet方法的使用，确保了对value的原子自增操作，避免了多线程并发访问时的竞态条件问题。
 *
 * 这个例子展示了compareAndSet方法在并发编程中的应用，能够实现对共享变量的安全操作。
 */
