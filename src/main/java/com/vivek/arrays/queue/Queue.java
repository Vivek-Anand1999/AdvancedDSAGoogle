package com.vivek.arrays.queue;

//Circuar Queue Implementation
public class Queue {
    public int front;
    public int rear;
    public int size;
    public int[] queue;

    public Queue(int size) {
        this.queue = new int[size];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % queue.length == front;
    }

    public void enqueue(int val) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        size++;
    }

    public void deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            front = (front + 1) % queue.length;
            queue[front] = 0; // Optional: Clear the value
            size--;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            return queue[(front + 1) % queue.length];
        }
    }
    public int getSize() {
        return size;
    }

    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
        for (int i = 0; i < queue.length; i++) {
            queue[i] = 0; // Optional: Clear the values
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.getSize());
        
        queue.deQueue();
        System.out.println("After dequeue, front element: " + queue.peek());
        System.out.println("Queue size after dequeue: " + queue.getSize());

        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("After enqueueing 40 and 50, front element: " + queue.peek());
        System.out.println("Queue size after enqueue: " + queue.getSize());
        
        queue.clear();
        System.out.println("Queue cleared. Is empty? " + queue.isEmpty());
    }

}
