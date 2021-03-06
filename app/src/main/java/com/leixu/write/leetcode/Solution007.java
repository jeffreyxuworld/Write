package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/2.
 *
 * Description

 Reverse digits of an integer.

 Example1: x = 123, return 321

 Example2: x = -123, return -321

 Spoilers:

 Have you thought about this?

 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 Note:

 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.


 给你一个整型数，求它的逆序整型数，而且有个小坑点，当它的逆序整型数溢出的话，那么就返回0，用我们代码表示的话可以求得结果保存在long中，最后把结果和整型的两个范围比较即可。

 *
 */

public class Solution007 {


    public int reverse(int x){
        long res = 0;
        for(; x != 0; x /= 10){   // x /= 10; 等同于 x = (int)(x / 10);
            res = res * 10 + x % 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;

    }




    public static void main(String[] args){
        Solution007 solution = new Solution007();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(100));
        System.out.println(solution.reverse(1000000003));

    }





}
