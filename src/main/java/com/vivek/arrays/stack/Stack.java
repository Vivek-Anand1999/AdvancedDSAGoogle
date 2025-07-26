package com.vivek.arrays.stack;

public class Stack {
    public int top;
    public int size;
    public int[] stack;

    public Stack(int size) {
        this.stack = new int[size];
        this.size = 0;
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = value;
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        stack[--top] = 0;
        size--;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return size == stack.length;
    }

    public int peek(int pos) {
        if (pos > top + 1 || pos == 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        return stack[top - pos + 1];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        int pos = 6;
        System.out.println("Element at position " + pos + ": " + stack.peek(pos));

    }

}
