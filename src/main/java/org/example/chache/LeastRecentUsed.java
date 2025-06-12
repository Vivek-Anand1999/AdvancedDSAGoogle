package org.example.chache;

import org.example.model.CacheNode;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentUsed {
    public static CacheNode head = new CacheNode(0, 0);
    public static CacheNode tail = new CacheNode(0, 0);
    public static HashMap<Integer, CacheNode> cache = new HashMap<>();
    public static int size = 0;
    public static int capacity;

    public LeastRecentUsed(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public static void set(int key, int value) {
        if (cache.containsKey(key)) {
            CacheNode nodeToBeDeleted = cache.get(key); // took that address
            remove(nodeToBeDeleted); // remove from the list
            insertAtLast(nodeToBeDeleted); // insert at last
            nodeToBeDeleted.value = value;
        } else {
            if (size < capacity) {
                CacheNode node = new CacheNode(key, value);
                cache.put(key, node);
                insertAtLast(node);
                size++;
            } else {
                CacheNode nodeToBeDeleted = head.next;
                cache.remove(nodeToBeDeleted.key);
                remove(nodeToBeDeleted);
                CacheNode temp = new CacheNode(key, value);
                cache.put(temp.key, temp);
                insertAtLast(temp);
            }
        }

    }

    public static int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode nodeToBeDeleted = cache.get(key);
            remove(nodeToBeDeleted);
            insertAtLast(nodeToBeDeleted);
            return nodeToBeDeleted.value;
        } else {
            return -1;
        }
    }

    private static void insertAtLast(CacheNode temp) {
        temp.next = tail;
        CacheNode tailPrevious = tail.prev;
        tailPrevious.next = temp;
        temp.prev = tailPrevious;
        tail.prev = temp;
    }

    private static void remove(CacheNode current) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public static void main(String[] args) {
        LeastRecentUsed lru = new LeastRecentUsed(4);
        lru.set(1, 10);
        lru.set(2, 20);
        lru.set(3, 30);
        lru.set(4, 40);
        lru.set(3, 50);

        for (Map.Entry<Integer, CacheNode> entry : LeastRecentUsed.cache.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().value);
        }

    }
}
