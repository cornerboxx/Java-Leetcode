package com.cornerboxx.leetcode;


import org.junit.Test;

/**
 * 0-50
 */
public class Leetcode_2 {

    @Test
    public void main() {
        ListNode l1 = buildNodes(7,4,3);
        ListNode l2 = buildNodes(5,6,4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ten = (l1.val + l2.val) / 10;
        ListNode first = new ListNode((l1.val + l2.val) % 10);
        ListNode next = first;
        while ((l1 != null && l1.next !=null) || (l2 != null&& l2.next !=null) || ten > 0) {
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + ten;
            if (val >= 10) {
                ten = val / 10;
                val = val % 10;
            } else {
                ten = 0;
            }
            next.next = new ListNode(val);
            next = next.next;
        }
        return first;
    }

    @Test
    public void testBuild() {
        ListNode l1 = buildNodes(2,4,3);
        System.out.println(l1);
    }

    public ListNode buildNodes(Integer... integers){
        ListNode first = new ListNode(integers[0]);
        ListNode cur = first;
        for (int i = 1; i < integers.length; i++) {
            cur.next = new ListNode(integers[i]);
            cur = cur.next;
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

