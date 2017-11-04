package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/3.
 *
 * Remove Duplicates from Sorted Array

 Description

     Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example, Given input array nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 从一个有序的数组中移除重复的元素，并返回之后数组的长度。我的思路是判断长度小于等于1的话直接返回原长度即可，否则的话遍历一遍数组，用一个tail变量指向尾部，如果后面的元素和前面的元素不同，就让tail变量加一，最后返回tail即可。
 *
 */

public class Solution026 {


    public int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len <= 1) return len;
        int tail = 1;
        for(int i = 1; i < len; ++i){
            if(nums[i-1] != nums[i]){
                nums[tail++] = nums[i];
            }
        }
        return tail;

    }


    public static void main(String[] args) {
        Solution026 solution = new Solution026();
        int[] data = new int[]{0, 1, 1, 2, 3, 3, 3};
        int len = solution.removeDuplicates(data);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }

}
