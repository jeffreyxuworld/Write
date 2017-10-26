package com.leixu.write.util;

import java.util.Arrays;

/**
 * Created by Lei on 2017/10/25.
 *
 */

public class MergeSort {


    public static class LinkedNode<V extends Comparable<V>> {
        public V value;
        public LinkedNode<V> next;

        public LinkedNode(V value) {
            this.value = value;
        }
        public LinkedNode(V value, LinkedNode<V> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static <T extends Comparable<T>> LinkedNode<T> prepareSortedLinkedList(T...list) {
        Arrays.sort(list);
        LinkedNode<T> head = new LinkedNode<>(list[0]);
        LinkedNode<T> begin = head;
        for (int i = 1; i < list.length; i++) {
            begin.next = new LinkedNode<>(list[i]);
            begin = begin.next;
        }
        return head;
    }

    public static <T extends Comparable<T>> LinkedNode<T> cloneLinkedList(LinkedNode<T> head) {
        if (head == null) {
            return null;
        }
        LinkedNode<T> result = new LinkedNode<>(head.value);
        LinkedNode<T> clonedList = result;
        while (true) {
            head = head.next;
            if (head != null) {
                clonedList.next = new LinkedNode<>(head.value);
                clonedList = clonedList.next;
            } else {
                break;
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> void dumpLinkedList(LinkedNode<T> head) {
        while (true) {
            if (head != null) {
                System.out.print(String.valueOf(head.value) + ' ');
            } else {
                break;
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedNode<String> head11 = prepareSortedLinkedList("dump", "just", "found", "get");
        LinkedNode<String> head21 = cloneLinkedList(head11);
        dumpLinkedList(head11);
        System.out.println("-------------------------------------------");
        dumpLinkedList(head21);
        System.out.println("-------------------------------------------");
        LinkedNode<String> head12 = prepareSortedLinkedList("get", "zara", "yes", "but", "row", "ok", "another");
        LinkedNode<String> head22 = cloneLinkedList(head12);
        dumpLinkedList(head12);
        System.out.println("-------------------------------------------");
        dumpLinkedList(head22);
        // end prepare
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++\n");
        // start test
        LinkedNode<String> result1 = mergeSortedLinkedList1(head11, head12);
        dumpLinkedList(result1);
        System.out.println("-------------------------------------------");
        LinkedNode<String> result2 = mergeSortedLinkedList2(head21, head22);
        dumpLinkedList(result2);
    }

    /** recusive. return head node as ascending. will change parameters, non reentrant. */
    public static <T extends Comparable<T>> LinkedNode<T> mergeSortedLinkedList1(LinkedNode<T> a, LinkedNode<T> b) {
        LinkedNode<T> head;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (isFirstLessThanSecond(a.value, b.value)) {
            head = a;
            head.next = mergeSortedLinkedList1(a.next, b);
        } else {
            head = b;
            head.next = mergeSortedLinkedList1(a, b.next);
        }
        return head;
    }

    /** virtual node + loop. return head node as ascending. will change parameters, non reentrant. */
    public static <T extends Comparable<T>> LinkedNode<T> mergeSortedLinkedList2(LinkedNode<T> a, LinkedNode<T> b) {
        LinkedNode<T> header = null, head = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        while (true) {
            if (isFirstLessThanSecond(a.value, b.value)) {
                if (head == null) {
                    header = head = a;
                } else {
                    head.next = a;
                    head = head.next;
                }
                a = a.next;
            } else {
                if (head == null) {
                    header = head = b;
                } else {
                    head.next = b;
                    head = head.next;
                }
                b = b.next;
            }
            if (a == null) {
                head.next = b;
                break;
            } else if (b == null) {
                head.next = a;
                break;
            }
        }
        return header;
    }

    /**
     * 1. null is smallest;
     * 2. if first == null && second == null then return true;
     * 3. if first equals second then return false;
     */
    private static <T extends Comparable<T>> boolean isFirstLessThanSecond(T first, T second) {
        if (first == null) {
            return true;
        }
        if (second == null) {
            return false;
        }
        return first.compareTo(second) < 0;
    }


}
