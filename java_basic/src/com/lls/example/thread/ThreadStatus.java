package com.lls.example.thread;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 线程通信：2个线程依次交替执行i++
 * wait()/wait(long)方法都会释放锁，让出系统资源，需要被主动唤醒      sleep(long)释放cpu，不释放锁
 * notify随机换取等待队列中的一个线程，notifyAll唤醒所有等待队列的线程，这些线程都进入同步/阻塞队列，全部为阻塞状态,notify所在同步方法执行完毕后才会释放锁
 * 等待队列存放状态为waiting和timed_waiting状态的线程，阻塞队列存放blockd线程
 * A线程如果调用了B线程的join方法，A线程会一直处于等待直到B线程死亡
 * LockSupport.park()/LockSupport.parkNanos(long nanos),LockSupport.parkUntil(long deadlines), 当前线程进入WAITING/TIMED_WAITING状态。对比wait方法,不需要获得锁就可以让线程进入WAITING/TIMED_WAITING状态，需要通过LockSupport.unpark(Thread thread)唤醒
 * Thread.yield() 让出cpu资源，线程回到可运行状态，
 * @author liulusheng
 * @since 2020/1/10
 */
public class ThreadStatus {
    private int i = 0;
    private Thread thread1;
    private Thread thread2;
    private boolean flag = true;

    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        return format.format(new Date()) + " ";
    }

    public static void testTimedWaiting() throws InterruptedException {
        System.out.println(getCurrentTime());
        //构建一个线程任务
        Runnable task1 = () -> {
            try {
//                LockSupport.park();
//                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5000));
//                LockSupport.parkUntil(System.currentTimeMillis()+5000L);
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("=================");
            System.out.println(getCurrentTime() + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().toString());
            System.out.println("=================");
        };
        Thread thread = new Thread(task1, "test1");
        //新建状态
        System.out.println("创建线程-->" + thread.getState());
        thread.start();
        //可运行状态
        System.out.println("启动线程-->" + thread.getState());
        Thread.sleep(3000);
        //定时等待状态
        System.out.println(getCurrentTime() + thread.getState());
//        LockSupport.unpark(thread);
        Thread.sleep(3000);
        //中止状态
        System.out.println(getCurrentTime() + thread.getState());
    }

    public void synctest(Object obj) throws InterruptedException {
        synchronized (obj) {
            do {
                i++;
                Thread currentThread = Thread.currentThread();
                System.out.println(getCurrentTime()+"当前线程" + currentThread.getName() + "计算i++=" + i + "  线程thread1状态：" + thread1.getState() + " 线程thread2状态：" + thread2.getState());
                //线程1
                if (flag) {
                    flag = false;
//                    Thread.yield();
                    obj.wait(3000L); //释放锁
//                    Thread.sleep(3000L);//不释放锁
//                    LockSupport.parkUntil(System.currentTimeMillis()+3000L);
                    obj.notify(); //随机唤醒等待队列中的一个线程
//                    System.out.println();
                    System.out.println("当前线程" + currentThread.getName() + "  线程thread1状态：" + thread1.getState() + " 线程thread2状态：" + thread2.getState());
                }
                //线程2
                if (!flag) {
                    flag = true;
                    obj.notify();
//                    System.out.println();
//                    System.out.println("当前线程" + currentThread.getName() + "  线程thread1状态：" + thread1.getState() + " 线程thread2状态：" + thread2.getState());
                    obj.wait();
                }
            } while (i < 100);

        }
    }

    public void initThread() throws InterruptedException {
        Object object = new Object();
        Runnable task1 = () -> {
            try {
                this.synctest(object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try {
                this.synctest(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        thread1 = new Thread(task1, "thread1");
        thread2 = new Thread(task2, "thread2");
        thread1.start();
        thread2.start();
//        thread1.join();
//        thread2.join();
    }


    public static void main(String[] args) throws InterruptedException {

//        testTimedWaiting();
        ThreadStatus threadStatus = new ThreadStatus();
        threadStatus.initThread();


    }
}
