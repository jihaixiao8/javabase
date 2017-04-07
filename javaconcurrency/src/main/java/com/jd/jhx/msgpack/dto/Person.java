package com.jd.jhx.msgpack.dto;

import org.msgpack.annotation.Message;

/**
 * Created by jihaixiao on 2017/3/10.
 */
@Message
public class Person {

    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
