package com.lls.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liulusheng
 * @since 2020/1/9
 */
public class ThreadPool {
    public static void main(String[] args) {
       ThreadPoolExecutor executor= new ThreadPoolExecutor(10,20,0, TimeUnit.MINUTES,new ArrayBlockingQueue<>(5));
        System.out.println(executor.toString());
        executor.prestartAllCoreThreads();
        System.out.println(executor.toString());
        executor.execute(()-> System.out.println(Thread.currentThread().toString()));
        System.out.println(executor.toString());
    }

    public static void  SingleThreadExecutorTest(){
//        Executors.newSingleThreadExecutor()
    }

}
