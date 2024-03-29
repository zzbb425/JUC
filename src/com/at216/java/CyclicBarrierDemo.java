package com.at216.java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Classname CyclicBarrierDemo
 * @Description TODO
 * @Date 2019/9/10 16:24
 * @Created by 10474
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            final  int temp=i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
