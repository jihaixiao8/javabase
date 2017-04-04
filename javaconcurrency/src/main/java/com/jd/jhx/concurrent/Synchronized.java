package com.jd.jhx.concurrent;

/**
 * Created by jihaixiao on 2017/4/4.
 */
public class Synchronized {

    public static void main(String[] args) {
        //对Synchronized.class对象加锁
        synchronized (Synchronized.class) {
            //静态同步方法，对Synchronized.class对象加锁
            m();
        }
    }

    public static synchronized void m() {
        System.out.println("123");
    }
}
