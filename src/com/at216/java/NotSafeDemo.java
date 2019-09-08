package com.at216.java;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Classname NotSafeDemo
 * @Description 线程集合安全
 * @Date 2019/9/8 22:34
 * @Created by 10474
 */
public class NotSafeDemo {
    public static void main(String[] args) {
        /*
        *   解决办法如下:
        *   1.使用vector来解决
        *   2.使用Collections.synchronizedList(new ArrayList<>())
        *   3.使用new CopyOnWriteArrayList<>();
        *
        *   在高并发的情况下使用第三种来解决  第一种只能一个一个来速度有点慢
        * */
        List<String> list =new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>(); //new ArrayList<>();

        //线程不是安全的举例
        /*
        *   1.java.util.ConcurrentModificationException 表示并发修改异常
        * */
        for (int i = 0; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
