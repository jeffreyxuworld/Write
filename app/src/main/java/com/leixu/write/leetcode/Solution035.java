package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/3.
 *
 * Search Insert Position

 Description

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.

 [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4 [1,3,5,6], 0 → 0


 从一个没有重复元素的已排序数组中找到插入位置的索引。因为数组已排序，所以我们可以想到二分查找法，因为查找到的条件是找到第一个等于或者大于target的元素的位置，所以二分法略作变动即可。
 *
 */

public class Solution035 {

    public int searchInsert(int[] nums, int target){
        int left = 0, right = nums.length -1, mid = (right + left) >> 1;
        while (left <= right){
            if(target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
            mid = (right + left) >> 1;
        }
        return left;

    }


    public static void main(String[] args) {
        Solution035 solution = new Solution035();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 7));
        System.out.println(solution.searchInsert(nums, 0));
    }






}
