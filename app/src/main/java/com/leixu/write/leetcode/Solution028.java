package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/3.
 *
 * Implement strStr()

 Description

 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 从主串中找到子串的索引，如果找不到则返回-1，当字串长度大于主串，直接返回-1，然后我们只需要遍历比较即可。
 *
 */

public class Solution028 {

    public int strStr(String haystack, String needle){
        int l1 = haystack.length(), l2 = needle.length();
        if(l1 < l2) return -1;
        for(int i = 0; ; i++){
            for(int j = 0; ; j++){
                if(j == l2) return i;
                if(i + j == l1) return -1;
                if(haystack.charAt(i + j) != needle.charAt(j)) break;

            }
        }

    }


    public static void main(String[] args) {
        Solution028 solution = new Solution028();
        System.out.println(solution.strStr("12345", "45"));
        System.out.println(solution.strStr("12345", "3"));
    }



}
