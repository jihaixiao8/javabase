package com.jd.jhx.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by jihaixiao on 2017/4/4.
 */
public class SleepUtil {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
