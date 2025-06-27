package com.vivek.problems.linkedlist;

import com.vivek.model.ListNode;

import java.util.HashMap;

public class LongestPalindrome {
    public static void main(String[] args) {
//        ListNode head = new ListNode("2");
//        head.next = new ListNode("3");
//        head.next.next = new ListNode("7");
//        head.next.next.next = new ListNode("3");
//        head.next.next.next.next = new ListNode("2");
//        head.next.next.next.next.next = new ListNode("12");
//        head.next.next.next.next.next.next = new ListNode("24");

//        System.out.printf("Longest palindrome in list %s\n", longestPalindrome(head));
        test();

    }

    public static int longestPalindrome(ListNode list) {
        ListNode previous = null;
        ListNode current = list;
        int ans = 1;
        while (current != null) {
            ListNode currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
            int oddLength = countOccurance(previous.next, current);
            int evenLength = countOccurance(previous, current);
            int result = Math.max(oddLength * 2 + 1, evenLength * 2);
            ans = Math.max(ans, result);

        }
        return ans;
    }

    private static int countOccurance(ListNode next, ListNode current) {
        int count = 0;
        while (next != null && current != null) {
            if (next.val != current.val) {
                count++;
                next = next.next;
                current = current.next;
            } else {
                break;
            }
        }
        return count;
    }

    public static void test() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.remove(3);
        System.out.println(map);
    }
}
