package com.at216.java;

import javax.print.attribute.standard.MediaSizeName;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Classname BlockingQueueDemo
 * @Description TODO
 * @Date 2019/9/10 18:06
 * @Created by 10474
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

       /* blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");*/


        blockingQueue.offer("a");
        blockingQueue.offer("b");

    }
}
