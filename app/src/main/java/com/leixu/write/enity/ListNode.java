package com.leixu.write.enity;

/**
 * Created by Lei on 2017/10/20.
 * 单向链表定义
 */

public class ListNode {

    int val; // 数据域
    ListNode next; // 指针域

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 非递归实现很简单，只需要遍历一遍链表，在遍历过程中，把遍历的节点一次插入到头部。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    /**
     * 翻转head->为首的链表， 然后head变为尾部节点
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }




    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        ListNode h = head;
        while (null != h) {
            System.out.print(h.getVal() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        // head = reverse1(head);
        head = reverseList(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }

    }


}
