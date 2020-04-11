package DP.easy;

/**
 * 最大子列和
 */
public class P53 {
    public int maxSubArray(int[] nums) {
        int[] sumEndi = new int[nums.length];
        sumEndi[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
            sumEndi[i] = Math.max(sumEndi[i-1] + nums[i], nums[i]);
            if (max < sumEndi[i])
                max = sumEndi[i];
        }
        return max;
    }
}
