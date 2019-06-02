package com.jzz.solutions.linkedlist;

/**
 * Problems:
 * 2. Add Two Numbers
 *
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbers {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0), curr = head;
        int val, carry = 0;
        while(null != l1 || null != l2){
            val = (null == l1 ? 0 : l1.val);
            val += (null == l2 ? 0 : l2.val);
            val += carry;
            curr.next = new ListNode(val % 10);
            carry = val / 10;
            curr = curr.next;
            if(null != l1){
                l1 = l1.next;
            }
            if(null != l2){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            curr.next = new ListNode(1);
        }
        return head.next;
    }



}
