package com.leixu.write.enity;

/**
 * Created by Lei on 2017/10/25.
 *
 */

public class Node {

    public int data; //数据域
    public Node next; //指针域

    public Node(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}





