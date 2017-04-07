package com.jd.jhx.msgpack;

import com.jd.jhx.msgpack.dto.Person;
import com.jd.jhx.msgpack.dto.PersonNew;
import org.msgpack.MessagePack;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by jihaixiao on 2017/3/10.
 */
public class MsgPackMain {

    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setAge(22);
        p.setName("小王");
        MessagePack messagePack = new MessagePack();
        byte[] bytes = messagePack.write(p);
        System.out.println(Arrays.toString(bytes)+",length:"+bytes.length);
        PersonNew serialPerson = messagePack.read(bytes,PersonNew.class);
        System.out.println(serialPerson);
    }

}
