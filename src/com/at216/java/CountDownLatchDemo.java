package com.at216.java;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname CountDownLatchDemo
 * @Description TODO
 * @Date 2019/9/10 15:38
 * @Created by 10474
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName()+"\t"+"国被灭");
                countDownLatch.countDown();
            }, CountDownEnum.forEach_CountDownEnum(i).getNewMess()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"一统华夏");
    }



    private static void countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName()+"\t"+"号同学离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"关灯锁门");
    }
}
