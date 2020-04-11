package greedy.mid;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class P55 {
    public boolean canJump(int[] nums) {
        if (nums.length < 1)
            return true;
        int last = nums.length - 1;
        int i = last-1;
        while (i>=0){
            if (nums[i] + i > last){
                last = i;
            }
            if (last == 0)
                return true;
            i--;
        }
        return  false;
    }
}
