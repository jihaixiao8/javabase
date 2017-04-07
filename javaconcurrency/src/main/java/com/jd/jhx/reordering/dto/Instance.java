package com.jd.jhx.reordering.dto;

import org.msgpack.annotation.Message;

/**
 * Created by jihaixiao on 2017/2/24.
 */
@Message
public class Instance {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
