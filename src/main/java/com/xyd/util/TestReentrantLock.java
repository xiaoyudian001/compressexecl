package com.xyd.util;


import java.sql.SQLOutput;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    private final static ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("主线程："+Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                REENTRANT_LOCK.lock();
                try{
                    drawMoney();
                }catch (Exception e){

                }finally {
                    REENTRANT_LOCK.unlock();
                }


            }
        }, "线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                REENTRANT_LOCK.lock();
                try{
                    drawMoney();
                }catch (Exception e){

                }finally {
                    REENTRANT_LOCK.unlock();
                }
            }
        }, "线程2").start();
    }

    private static void drawMoney() {
        System.out.println(Thread.currentThread().getName() + "正在取钱。。。。");
        sleep(3000);
        System.out.println(Thread.currentThread().getName() + "取完了。。。。");

    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
