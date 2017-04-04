package com.jd.jhx.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jihaixiao on 2017/4/4.
 */
public class WaitNotify {


    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            //加锁
            synchronized (lock) {
                //当 条件不满足时，继续wait,同时释放了lock的锁。
                while (flag) {
                    System.out.println(Thread.currentThread()+"flag is true.wait@"+
                    new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足，完成工作。
                System.out.println(Thread.currentThread()+"flag is false.running@"+
                new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            //加锁
            synchronized (lock) {
                //获取到lock的锁，然后进行通知，通知时不会释放lock的锁
                //直到当前线程释放锁，WaitThread才会从wait方法中返回。
                System.out.println(Thread.currentThread()+"hold lock.notify"+
                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtil.second(5);
            }

            //再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread()+"hold lock again.notify"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtil.second(5);

            }
        }
    }

}
