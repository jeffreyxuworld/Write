package com.leixu.write.util;

import com.leixu.write.enity.Node;

/**
 * Created by Lei on 2017/10/25.
 *
 */

public class ListNodeUtil {

    public static void main(String[] args) {






    }


    public Node mergeTwoListNode(Node l1, Node l2){

        Node head=null;
        if(l1==null){//先判断两个链表是否为空
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.data<=l2.data){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        Node temp=head;
        while(l1!=null&&l2!=null){
            if(l1.data<=l2.data){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null){
            temp.next=l1;
        }
        if(l2!=null){
            temp.next=l2;
        }
        return head;
    }



}
