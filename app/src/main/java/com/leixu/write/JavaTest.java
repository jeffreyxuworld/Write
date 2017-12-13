package com.leixu.write;

import com.leixu.write.enity.Node;
import com.leixu.write.util.FindShortestBTPath;
import com.leixu.write.util.StringOperator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Lei on 2017/10/25.
 *
 */

public class JavaTest {


    public static void main(String[] args) {

//        Node head = new Node(0);
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        head.setNext(node1);
//        node1.setNext(node2);
//        node2.setNext(node3);
//
//        // 打印反转前的链表
//        Node h = head;
//        while (null != h) {
//            System.out.print(h.getData() + " ");
//            h = h.getNext();
//        }
//        // 调用反转方法
//        head = reverse2(head);
//
//        System.out.println("\n**************************");
//        // 打印反转后的结果
//        while (null != head) {
//            System.out.print(head.getData() + " ");
//            head = head.getNext();
//        }


//        System.out.println("\n**************************");


//        countPeople();


        //约瑟夫问题
//        Scanner s = new Scanner(System.in);
//        System.out.print("请输入总人数：");
//        int totalNum = s.nextInt();
//        System.out.print("请输入报数大小：");
//        int cycleNum = s.nextInt();
//        s.close();
//        int a = josephusProblem(totalNum, cycleNum);
//        System.out.println("最后一个人的序号：" + a);


//        System.out.println(StringOperator.getFirstStr1("alibaba"));
//        System.out.println(StringOperator.getFirstStr1("taobao"));
//        System.out.println(StringOperator.getFirstStr1("aabbc"));

        StringOperator.getFirstStr2("aabbc");

    }


    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static Node reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }


    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse2(Node head) {
        if (head == null)
            return head;
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }


    /**
     * 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
     */
    public static void countPeople() {
        int arr[] = new int[101];//报数从1开始所以数组大小为n+1
        int n=100, m=3;

        int i;
        int dead = 0;   //表示已经死了多少人
        int num = 0;    //num模拟报数
        for (i = 1;i<= n; i++) {
            //开始时每个人都可以报数，为了能得到最后一个人的编号，我们让初始值为i下标
            arr[i] = i;
        }

        for (i = 1;; i++){
            if (i > n) {
                //如果大于总人数，我们就从头开始
                i = i%n;
            }

            if (arr[i] > 0){
                //如果当前这个人没有死，就报数
                num++;
            }

            if (m == num && dead != n-1){
                //如果当前这个人报的数等于m 并且没有已经死亡n-1个人
                num = 0;
                arr[i] = 0;
                dead++;
            } else if(m == num && dead == n-1){
                //如果这个人报数等于m，并且已经死了n-1个人，说明当前这个人就是最后的一个活着的了。
                System.out.print(arr[i]+"");
                break;
            }

        }

    }


    /**
     * 约瑟夫问题
     * @param n
     * @param m
     * @return
     */
    public static int josephusProblem(int n, int m) {
        if(n == 0 || m == 0)
            return -1;
        if(n == 1 && m == 1)
            return -1;
        List<Integer> alist = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            alist.add(i);
        //初值设为-1，
        int index = -1;
        while(alist.size() > 1){
            index = (index+m)%alist.size();
            alist.remove(index);
            //从上一个位置开始计数
            index--;
        }
        return alist.get(0);


    }





}
