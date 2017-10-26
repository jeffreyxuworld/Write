package com.leixu.write.util;

/**
 * Created by Lei on 2017/10/25.
 * 现有两个有序（升序）的单向链表，请编写程序将这两个链表合并成一个，并确保合并后的链表也是升序的
 */

public class ListNodeTest {



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * 将单项链表进行排序
     *
     * @author Henry
     * @createDate 2016-10-27
     */
    class Solution {
        /**
         * 将单项链表进行排序
         *
         * @author Henry
         * @createDate 2016-10-27
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = null;
            result = getResult(result, l1, l2);
            return result;
        }
        /**
         * 一开始的时候想写while，但是发现无法获得头结点，并且定义变量较为复杂。
         * 回头一想，认为递归可以直接实现队列的排序。所以又重新编写一下逻辑。
         * 这样编写节约内存，提升效率。
         *
         * @param result null
         * @param l1 单项链表1 头项
         * @param l2 单项链表2 头项
         * @return 返回头结点
         */
        public ListNode getResult(ListNode result, ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                result = l2;
                //result.next = getResult(result.next, l1, l2.next);
                return result;
            }
            if (l2 == null) {
                result = l1;
                //result.next = getResult(result.next, l1.next, l2);
                return result;
            }
            if (l1.val > l2.val) {
                result = l2;
                l2 = l2.next;
            } else {
                result = l1;
                l1 = l1.next;
            }
            result.next = getResult(result.next, l1, l2);
            return result;
        }
    }

    /**
     * while 将单项链表进行排序
     * 如果l1或l2为空，则返回单边。
     * @author Henry
     * @date 2017-7-10
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode other = l1.val >= l2.val ? l1 : l2;
        ListNode prevHead = head;
        ListNode prevOther = other;
        while (prevHead != null) {
            ListNode next = prevHead.next;
            if (next != null && next.val > prevOther.val) {
                prevHead.next = prevOther;
                prevOther = next;
            }
            if(prevHead.next==null){
                prevHead.next=prevOther;
                break;
            }
            prevHead=prevHead.next;
        }
        return head;
    }


    public static void main(String[] args) {

//        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(5);
//        l1.next.next.next = new ListNode(7);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(5);
//
//        ListNode l = new Solution().mergeTwoLists(l1, l2);
//        while (l != null) {
//            System.out.println(l.val);
//            l = l.next;
//        }


    }


}
