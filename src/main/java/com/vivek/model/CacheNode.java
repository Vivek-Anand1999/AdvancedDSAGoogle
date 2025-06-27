package com.vivek.model;

public class CacheNode {
    public int value;
    public CacheNode next;
    public CacheNode prev;
    public int key;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
