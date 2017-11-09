package com.leixu.write.leetcode;

/**
 * Created by Lei on 2017/11/4.
 *
 * Maximum Subarray

 Description

     Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

     For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.

     More practice:

     If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */

public class Solution053 {


    /**
     *  求数组中子数组的最大和，这种最优问题一般第一时间想到的就是动态规划，我们可以这样想，当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，
         如果出现部分序列小于零的情况，那肯定就是从当前元素算起。其转移方程就是dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);，
         由于我们不需要保留dp状态，故可以优化空间复杂度为1，即dp = nums[i] + (dp > 0 ? dp : 0);。
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int len = nums.length, dp = nums[0], max = dp;
//        for (int i = 1; i < len; ++i) {
//            dp = nums[i] + (dp > 0 ? dp : 0);
//            if (dp > max) max = dp;
//        }
//        return max;
//    }


    /**
     * 题目也给了我们另一种思路，就是分治，所谓分治就是把问题分割成更小的，最后再合并即可，我们把nums一分为二先，那么就有两种情况，一种最大序列包括中间的值，一种就是不包括，
     * 也就是在左边或者右边；当最大序列在中间的时候那我们就把它两侧的最大和算出即可；当在两侧的话就继续分治即可。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftAns = helper(nums, left, mid);
        int rightAns = helper(nums, mid + 1, right);
        int leftMax = nums[mid], rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; --i) {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            if (temp > rightMax) rightMax = temp;
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }



    public static void main(String[] args) {
        Solution053 solution = new Solution053();
        int[] nums0 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums0));
    }


}