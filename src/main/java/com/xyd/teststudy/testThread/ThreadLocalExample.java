package com.xyd.teststudy.testThread;

/**
 * <p>
 *     ThreadLocal 是 Java 中的一个线程局部变量工具类，它提供了一种在每个线程中存储和访问数据的机制。
 *     每个线程都拥有自己独立的 ThreadLocal 实例，可以在其中存储线程私有的数据，不同线程之间互不干扰。
 * </p>
 */
public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task1 = () -> {
            threadLocal.set(42);
            System.out.println("Thread 1: " + threadLocal.get());
        };

        Runnable task2 = () -> {
            threadLocal.set(84);
            System.out.println("Thread 2: " + threadLocal.get());
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
