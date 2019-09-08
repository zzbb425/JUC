package com.at216.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCTicket {
    public static void main(String[] args) {

        //买票的操作
        Ticket ticket = new Ticket();
        new Thread(()->{for (int i = 1; i <=40 ; i++) ticket.salry();},"A").start();
        new Thread(()->{for (int i = 1; i <=40 ; i++) ticket.salry();},"B").start();
        new Thread(()->{for (int i = 1; i <=40 ; i++) ticket.salry();},"C").start();

    }
}

class Ticket {

    private int number = 30;

    private Lock lock = new ReentrantLock();

    public void salry() {

        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "窗口卖出第" + number-- + "票" + " " + "还剩下" + number + "票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
