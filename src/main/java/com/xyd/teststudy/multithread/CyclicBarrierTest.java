package com.xyd.teststudy.multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private static final int NUM_RUNNERS = 4;

    public static void main(String[] args) {
        CyclicBarrier startBarrier = new CyclicBarrier(NUM_RUNNERS, () -> {
            System.out.println("All runners are ready. The race begins!");
        });

        CyclicBarrier finishBarrier = new CyclicBarrier(NUM_RUNNERS, () -> {
            System.out.println("All runners have finished the race!");
        });

        for (int i = 0; i < NUM_RUNNERS; i++) {
            Thread runner = new Thread(() -> {
                try {
                    System.out.println("Runner " + Thread.currentThread().getId() + " is ready.");
                    startBarrier.await(); // 等待所有选手准备就绪

                    // 模拟选手正在跑步
                    Thread.sleep((long) (Math.random() * 1000));

                    System.out.println("Runner " + Thread.currentThread().getId() + " has finished the race.");
                    finishBarrier.await(); // 等待所有选手完成比赛

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            runner.start();
        }
    }
}
