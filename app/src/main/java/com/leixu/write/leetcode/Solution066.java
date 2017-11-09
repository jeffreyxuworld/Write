package com.leixu.write.leetcode;

import java.util.Arrays;

/**
 * Created by Lei on 2017/11/9.
 *
 * Plus One

 Description

     Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.

     一个数字数组，高位在前，并且首位不为0除非这个数组就是[0]，让你给该数组低位加一求其结果，那么我们就模拟小学数学那样进位去算即可，如果一直进位到首位，
     这种情况也就是都是由9组成的数组，此时我们只要new出一个多一个长度的数组即可，并把第0个元素赋1即可。
 *
 */

public class Solution066 {

    public int[] plusOne(int[] digits){
        int p = digits.length - 1;
        if (digits[p] < 9) {
            digits[p] = ++digits[p];
        } else {
            do {
                digits[p--] = 0;
            } while (p >= 0 && digits[p] == 9);
            if (digits[0] != 0) {
                ++digits[p];
            } else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }


    public static void main(String[] args) {
        Solution066 solution = new Solution066();
        int[] digits = solution.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
    }

}
