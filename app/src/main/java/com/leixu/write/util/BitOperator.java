package com.leixu.write.util;

import android.util.Log;

/**
 * Created by Lei on 2017/10/20.
 * 位运算符
 */

public class BitOperator {


    /**
     * “a”的值是129，转换成二进制就是10000001，而“b”的值是128，转换成二进制就是10000000。根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000，即128。
     */
    public static void bitOperator1(){
        int a= 129;
        int b= 128;
//        System.out.println("a 和b 与的结果是："+(a&b));
        Log.i("Lei", "a 和b 与的结果是："+(a&b));
    }

    /**
     * a 的值是129，转换成二进制就是10000001，而b 的值是128，转换成二进制就是10000000，根据或运算符的运算规律，只有两个位有一个是1，结果才是1，可以知道结果就是10000001，即129。
     */
    public static void bitOperator2(){
        int a=129;
        int b=128;
        System.out.println("a 和b 或的结果是："+(a|b));
        Log.i("Lei", "a 和b 或的结果是："+(a|b));
    }

    /**
     * 如果位为0，结果是1，如果位为1，结果是0，下面看一个简单例子。
     */
    public static void bitOperator3(){
        int a=2;
//        System.out.println("a 非的结果是："+(~a));
        Log.i("Lei", "a 非的结果是："+ (~a)) ;
    }


    /**
     * a 的值是15，转换成二进制为1111，而b 的值是2，转换成二进制为0010，根据异或的运算规律，可以得出其结果为1101 即13
     */
    public static void bitOperator4(){
        int a=15;
        int b=2;
//        System.out.println("a 与 b 异或的结果是："+(a^b));
        Log.i("Lei", "a 与 b 异或的结果是："+(a^b));
    }


}
