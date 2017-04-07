package com.jd.jhx.concurrent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jihaixiao on 2017/4/6.
 */
public class ConnectionPoolTest {

    static ConnectPool pool = new ConnectPool(10);
    static CountDownLatch start = new CountDownLatch(1);

    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);

        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i =0;i<threadCount;i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke:"+(threadCount * count));
        System.out.println("got connection:"+got);
        System.out.println("not got connection:"+notGot);
    }

    static class ConnectionRunner implements Runnable {

        int count;

        AtomicInteger got;

        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.realeaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count --;
                }
            }
            end.countDown();
        }
    }

}
