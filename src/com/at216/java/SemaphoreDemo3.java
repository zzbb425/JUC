package com.at216.java;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Classname SemaphoreDemo3
 * @Description TODO
 * @Date 2019/9/10 16:37
 * @Created by 10474
 */
public class SemaphoreDemo3 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t"+"占到了车位");
                    TimeUnit.SECONDS.sleep((int)(Math.random()*8));
                    System.out.println(Thread.currentThread().getName()+"\t"+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }


    }
}
