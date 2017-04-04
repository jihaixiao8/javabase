package com.jd.jhx.datastructure;

/**
 * Created by jihaixiao on 2017/3/27.
 */
public class SkipList {

    private int level;

    private Node head;

    private static class Node {

        Object key;

        Object value;

        Node[] forward;

    }
}
