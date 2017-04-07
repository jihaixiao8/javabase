package com.jd.jhx.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by jihaixiao on 2017/4/5.
 */
public class Join1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Job());
        thread.start();
        thread.join();
        System.out.println("主线程才执行");
    }

    static class Job implements Runnable {

        public void run() {
            System.out.println("线程正在跑");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
