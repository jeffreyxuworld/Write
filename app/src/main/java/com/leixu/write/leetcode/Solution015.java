package com.leixu.write.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lei on 2017/11/2.
 *
 * Description

     Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]

    从数组中找出所有三个和为0的元素构成的非重复序列，这样的话我们可以把数组先做下排序，然后遍历这个排序数组，用两个指针分别指向当前元素的下一个和数组尾部，判断三者和与0的大小来移动两个指针，其中细节操作就是注意去重。
 *
 */

public class Solution015 {


    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2){
            if(nums[i] > 0){
                break;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < right && nums[left] == nums[left -1]) ++left;
                    while (left < right && nums[right] == nums[right + 1]) --right;
                }else if(sum < 0) ++left;
                else --right;
            }

            while(nums[i] == nums[++i] && i < nums.length - 2);

        }

        return list;

    }


    public static void main(String[] args) {
        Solution015 solution = new Solution015();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
