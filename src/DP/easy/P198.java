package DP.easy;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 */
public class P198 {
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = 0;
        for (int i=1; i<nums.length; i++){
            dp[0][i] = dp[1][i-1] + nums[i];
            dp[1][i] = Math.max(dp[0][i-1], dp[i][i-1]);
        }
        return Math.max(dp[0][nums.length-1], dp[1][nums.length-1]);
    }
}
