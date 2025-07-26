package com.vivek.arrays.LinkedList;

public class SinglyLinkedList {
    public Node head;
    public int size;

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        int[] array = { 40, 50, 60 };
        for (int num : array) {
            list.addLast(num);
        }
        int[] addFirst = { 9, 8, 7 };
        for (int num : addFirst) {
            list.addFirst(num);
        }
        list.print(list.head);

        System.out.println("Size of the list: " + list.size);
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        list.removeFirst();
        System.out.println("After removing first element:");
        list.print(list.head);
        list.removeLast();
        System.out.println("After removing last element:");
        list.print(list.head);
        System.out.println("Searching for 20: " + list.search(20));
        System.out.println("Searching for 100: " + list.search(100));
        list.insertAtPos(25, 1, list.head);
        System.out.println("After inserting 25 at position 1:");
        list.print(list.head);
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        size++;
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        size++;
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void print(Node head) {
        Node tempPointer = head;
        while (tempPointer != null) {
            System.out.print(tempPointer.val + " -> ");
            tempPointer = tempPointer.next;
        }
        System.out.println("null");
    }

    public int getFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        } else {
            return head.val;
        }
    }

    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Node tempPointer = head;
        while (tempPointer.next != null) {
            tempPointer = tempPointer.next;
        }
        return tempPointer.val;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        size--;
    }

    public boolean search(int target) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Node current = head;
        while (current != null) {
            if (current.val == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void insertAtPos(int val, int pos, Node head) {
        if (pos - 1 > size || pos < 1)
            throw new IllegalArgumentException("Position out of bounds");
        if (pos == 1) {
            addFirst(val);
            return;
        } else {
            Node newNode = new Node(val);
            size++;
            Node current = head;
            int count = 1;
            while (current != null && count < pos - 1) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

}
