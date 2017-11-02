package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/2.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * 从字符串数组中找出公共前缀，我的想法是找出最短的那个字符串的长度minLen，然后在0...minLen的范围比较所有字符串，如果比较到有不同的字符，那么直接返回当前索引长度的字符串即可，否则最后返回最短的字符串即可。
 *
 */

public class Solution014 {


    public String longestCommonPrefix(String[] strs){
        int len = strs.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for(String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for(int j = 0; j < minLen; ++j){
            for(int i = 1; i < len; ++i){
                if(strs[0].charAt(j) != strs[i].charAt(j)){
                    return strs[0].substring(0, j);
                }

            }

        }

        return strs[0].substring(0, minLen);


    }


    public static void main(String[] args){
        Solution014 solution = new Solution014();
        System.out.println(solution.longestCommonPrefix(new String[]{"abc", "abcd", "ab"}));


    }



}
