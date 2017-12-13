package com.leixu.write.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lei on 2017/12/13.
 * 字符串相关处理
 */

public class StringOperator {




    /** * 返回第一个不重复的字符 * @param s 所求的字符串 * @return 如果有返回该字符，如果不存在不重负的字符，返回null */
    public static Character get(String s) {
        // 判断边界条件
        if (s == null || s.length() < 1) {
            // 抛出异常
            throw new IllegalArgumentException("should not be null or empty");
        }
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer already = map.get(c);
            already = (already == null) ? 0 : already;
            map.put(s.charAt(i), ++already);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 给定一个字符串，求第一个不重复的字符
     * @param s
     * @return
     */
    public static String getFirstStr(String s) {
        char[] strs = s.toCharArray();
        // 定义哈希数组,大小为字符的取值范围即可
        int hashTable[] = new int[256];

        for (int i = 0; i < strs.length; i++) {
            hashTable[strs[i]]++;
        }

        for (int i=0; i < strs.length; i++) {
            if (hashTable[strs[i]] == 1) {
                return String.valueOf(strs[i]);
            }
        }

        return "";
    }


    public static String getFirstStr1(String tag) {

        int[] flag = new int[256];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;
        }
        for (int i = 0; i < tag.length(); i++) {
            int index = tag.charAt(i);
            if (flag[index]  >= 0) {
                flag[index] = -2;
            }else if(flag[index] == -1){
                flag[index] = i;
            }
        }
        int min = 256;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] < 0) {
                continue;
            }
            if (min > flag[i]) {
                min = flag[i];
            }
        }
//        System.out.println(tag.charAt(min));
        return  String.valueOf(tag.charAt(min));

    }



    public static void getFirstStr2(String tag) {
        int[] flag = new int[256];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = 0;
        }
        for (int i = 0; i < tag.length(); i++) {
            flag[tag.charAt(i)]++;
        }
        for (int i = 0; i < tag.length(); i++) {
            if (flag[tag.charAt(i)] == 1) {
                System.out.println(String.valueOf(tag.charAt(i)));
                break;
            }
        }
    }


}
