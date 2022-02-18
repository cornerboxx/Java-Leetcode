package com.cornerboxx.leetcode;


import org.junit.Test;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_2 {

    @Test
    public void main() {
        ListNode l1 = buildNodes(7, 4, 3);
        ListNode l2 = buildNodes(5, 6, 4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ten = (l1.val + l2.val) / 10;
        ListNode first = new ListNode((l1.val + l2.val) % 10);
        ListNode next = first;
        while ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || ten > 0) {
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
        ListNode l1 = buildNodes(2, 4, 3);
        System.out.println(l1);
    }

    public ListNode buildNodes(Integer... integers) {
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

