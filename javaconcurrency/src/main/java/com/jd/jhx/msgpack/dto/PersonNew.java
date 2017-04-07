package com.jd.jhx.msgpack.dto;

import org.msgpack.annotation.Message;

/**
 * Created by jihaixiao on 2017/3/10.
 */
@Message
public class PersonNew {


    private Integer age;

    private String name;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
