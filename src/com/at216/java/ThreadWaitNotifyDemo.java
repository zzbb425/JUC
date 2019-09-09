package com.at216.java;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ThreadWaitNotifyDemo
 * @Description TODO
 * @Date 2019/9/8 23:25
 * @Created by 10474
 */

/*
 *   多线程的三步走
 *
 *   1.高聚底合前提下 线程操作资源类
 *
 *   2.判断+干活+通知
 *
 *   3.注意线程之间的，虚假唤醒
 *
 * */

class AirConditioner {

    private int number = 0;

    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public  void addNumber() throws Exception {
        //判断
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }

            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            //唤醒
            condition.signalAll();
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
             lock.unlock();
        }


    }

    public  void subNumber() throws Exception {
        lock.lock();
        try {
            //判断
            while (number == 0) {
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //唤醒
            condition.signalAll();
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
             lock.unlock();
        }

    }

    /*public synchronized void addNumber() throws Exception {
        //判断
        while (number != 0) {
            this.wait();
        }

        //干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);

        //唤醒
        this.notifyAll();

    }

    public synchronized void subNumber() throws Exception {
        //判断
        while (number == 0) {
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //唤醒
        this.notifyAll();
    }*/
}


public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.addNumber();
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {

                    airConditioner.subNumber();
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {

                    airConditioner.addNumber();
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {

                    airConditioner.subNumber();
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
