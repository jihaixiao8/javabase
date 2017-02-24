package com.jd.jhx.reordering;

import com.jd.jhx.reordering.dto.Instance;

/**
 * Created by jihaixiao on 2017/2/24.
 */
public class InstanceFactory {

    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance;
    }

}
