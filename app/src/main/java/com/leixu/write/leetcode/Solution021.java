package com.leixu.write.leetcode;

import com.leixu.write.enity.ListNode;

/**
 * Created by Lei on 2017/11/3.
 *
 * Merge Two Sorted Lists

 Description

     Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example, Given input array nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 用一个新链表来合并两个已排序的链表，那我们只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，依次比较下去，
 最后，当其中一个链表到达了末尾，我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。

 */

public class Solution021 {

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            } else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;

        }

        temp.next = l1 != null ? l1 : l2;
        return head.next;

    }


    public static void main(String[] args) {
        Solution021 solution = new Solution021();
        ListNode listNode0 = ListNode.createTestData("[1,3,5,7,9]");
        ListNode listNode1 = ListNode.createTestData("[2,4,6,8,10]");
        ListNode.print(listNode0);
        ListNode.print(listNode1);
        ListNode.print(solution.mergeTwoList(listNode0, listNode1));


    }


}
