package com.jd.jhx.reordering;

import com.jd.jhx.reordering.dto.Instance;

/**
 * Created by jihaixiao on 2017/2/24.
 */
public class DoubleCheckLocking {

    private static volatile Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLocking.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

}
