package com.lls.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 三种线程的创建和启动
 *
 * @author liulusheng
 * @since 2019/12/25
 */
public class InitThread {

    public static void main(String[] args) throws Exception {
        //打印当前主线程的名称
        System.out.println(Thread.currentThread().getName());

        new InitThread1().start();

        new Thread(new InitThread2()).start();

        FutureTask<String> task= new FutureTask<>(new InitThread3());
        new Thread(task).start();
        //无论何种方式创建一个线程，要启动都要通过Thread类，实现Callable接口有返回值
        //打印返回值
        System.out.println(task.get());

    }
}

//继承thread类，重写thread类的run方法，缺点不能继承其他类
class InitThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "init1...");
        }
    }
}

//实现Runnable接口,线程启动要通过Thread类
class InitThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "init2...");
        }
    }
}
//实现Callable接口，线程启动要通过Thread类
class  InitThread3 implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "init3...");
        }
        return Thread.currentThread().getName();
    }
}

