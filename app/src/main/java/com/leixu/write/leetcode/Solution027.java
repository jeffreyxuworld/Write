package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/3.
 *
 * Remove Element

 Description

 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:

 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.

 移除数组中值等于val的元素，并返回之后数组的长度，并且题目中指定空间复杂度为O(1)，我的思路是用tail标记尾部，遍历该数组时当索引元素不等于val时，tail加一，尾部指向当前元素，最后返回tail即可。
 *
 */

public class Solution027 {

    public int removeElement(int[] nums, int val) {
        int tail = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        Solution027 solution = new Solution027();
        int[] data = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int len = solution.removeElement(data, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }

}
