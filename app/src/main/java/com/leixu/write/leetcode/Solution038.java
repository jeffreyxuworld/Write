package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/3.
 *
 * Count and Say

 Description

 The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221

 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"

 Example 2:

 Input: 4
 Output: "1211"

 数和说，根据如下序列1, 11, 21, 1211, 111221, ...，求第n个数，规则很简单,就是数和说，数就是数这个数数字有几个，
 说就是说这个数，所以1就是1个1：11,11就是有2个1：21，21就是1个2、1个1：1211，可想而知后面就是111221，思路的话就是按这个逻辑模拟出来即可。

 *
 */

public class Solution038 {

    public String countAndSay(int n){
        String str = "1";
        while (--n > 0){
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for(int j = 1; j < len; j++){
                if(chars[j - 1] == chars[j -1]){
                    times++;
                }else{
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }

            }
            str = sb.append(times).append(chars[len -1]).toString();

        }

        return str;
    }

    public static void main(String[] args) {
        Solution038 solution = new Solution038();
        for (int i = 1; i < 6; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }

}
