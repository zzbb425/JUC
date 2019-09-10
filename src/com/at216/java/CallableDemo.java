package com.at216.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CallableDemo
 * @Description TODO
 * @Date 2019/9/10 15:20
 * @Created by 10474
 */


/*
* 1.runnable 和 callable对比那些地方不同
*   1). runnable接口没有泛型   callable接口有泛型
*   2). runnable接口没有返回值 callable接口有返回值
*   3). runnable接口实现的方法是run() callable接口实先的方法是call()
* */

/*class  MyThread01 implements Runnable{

    @Override
    public void run() {

    }
}*/

class  MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("**********call()");
        return 3000;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println(Thread.currentThread().getName()+"******come in callable lambda express");
            TimeUnit.SECONDS.sleep(4);
            return 1024;
        });

        new Thread(futureTask,"AA").start();

        System.out.println("******callalbe");

        while(!futureTask.isDone()){
            System.out.println("*********wait");
        }

        System.out.println(futureTask.get());
    }
}
