package DP.mid;

/**
 * 最长上升子序列
 */
public class P300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums.length==1)
                return 1;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max;
            int result = 1;
            for (int i=1; i<dp.length; i++){
                max = 0;
                for (int j=0; j<i; j++){
                    if (nums[i] > nums[j]){
                        if (dp[j] > max)
                            max = dp[j];
                    }
                }
                dp[i] = max + 1;
                if (dp[i] > result)
                    result = dp[i];
            }
            return result;
        }
    }
}
