package com.at216.java;

/**
 * @Classname LambdaDome
 * @Description lambda表达使用的口诀   拷贝小括号   写死右箭头  落地大括号
 * @Date 2019/9/8 18:41
 * @Created by 10474
 */



/*
*   1.@FunctionalInterface使用这个注解标识了就只能写一个方法并且没有方法体的(lambda函数只能在接口中存在一个方法)
*
*   2.在接口中可以有多个default所修饰的方法并且带有方法体和可以有多个static修饰的方法并且带有方法体
*
* */

@FunctionalInterface
interface Foo
{

   // public void add();

    public int mul(int x,int y);

    default int del(int x,int y){
        return x/y;
    }

    static int dev(int x,int y){
        return x*y;
    }
}


public class LambdaDome {
    public static void main(String[] args) {

        //匿名函数的调用
        /*new Foo() {
            @Override
            public void add() {

            }
        };*/

       /* Foo foo=()->{
            System.out.println("你好");
        };


        foo.add();*/

        Foo foo = (int x, int y) -> {
            System.out.println("你好");
            return x * y;
        };
        System.out.println(foo.mul(3, 5));
    }
}
