package com.lls.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liulusheng
 * @since 2019/12/25
 */
public class ValatileTest {
    private static volatile AtomicInteger j = new AtomicInteger(0);
    private  static int b=0;
    public static void main(String[] args) {
        int c = 0;

        for (int i = 0; i < 1000 && b < 1000; ) {
            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+" :"+j.get());
                j.getAndIncrement();
//                    j++;
//                System.out.println(Thread.currentThread().getName()+" :"+j.get());
            }).start();
           Thread.currentThread().getThreadGroup().list();
//            j++;
            synchronized (j){
                i++;
                if (i == 1000) {
                    b++;
                    if (j.get() == 1000) {
                        i = 0;
                        j.set(0);
                        c++;
                    }

                }
            }

        }
        System.out.println("--------------"+Thread.currentThread().getName()+c);
    }
}
