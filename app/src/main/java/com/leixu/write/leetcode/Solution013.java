package com.leixu.write.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lei on 2017/11/2.
 *
 * Description

 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 题意是罗马数字转整型数，范围从1到3999，查看下百度百科的罗马数字介绍如下，

 相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
 小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；

 *
 */

public class Solution013 {


    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution013 solution = new Solution013();
        System.out.println(solution.romanToInt("DCXXI"));// 621
        System.out.println(solution.romanToInt("CCCXLVIII"));// 348
    }

}
