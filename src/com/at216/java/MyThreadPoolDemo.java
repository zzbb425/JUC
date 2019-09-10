package com.at216.java;

import java.util.concurrent.*;

/**
 * @Classname MyThreadPoolDemo
 * @Description TODO
 * @Date 2019/9/10 21:13
 * @Created by 10474
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService poolExecutor = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 1; i <= 10; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "处理业务");
                });
            }
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }


    }

    private static void threadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //  ExecutorService pool = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 10; i++) {
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "处理业务");
                });
                //TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
