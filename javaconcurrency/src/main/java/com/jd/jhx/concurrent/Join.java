package com.jd.jhx.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by jihaixiao on 2017/4/4.
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i=0;i<6;i++) {
            Thread t = new Thread(new Demino(previous),String.valueOf(i));
            t.start();
            previous = t;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate");
    }


    static class Demino implements Runnable {

        private Thread thread;

        public Demino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminate");
        }
    }
}
