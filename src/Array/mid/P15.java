package Array.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return null;
        for (int i=0; i<nums.length-2; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int low = i+1;
            int high = nums.length-1;
            while (low < high){
                if (nums[low] + nums[high] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    while (low < high){
                        if (nums[low+1] == nums[low]){
                            low++;
                        }
                        else {
                            low++;
                            break;
                        }
                    }
                    while (low < high){
                        if(nums[high-1] == nums[high]){
                            high--;
                        }
                        else {
                            high--;
                            break;
                        }
                    }
                }
                else if (nums[low] + nums[high] < target){
                    while (low < high){
                        if (nums[low+1] == nums[low]){
                            low++;
                        }
                        else {
                            low++;
                            break;
                        }
                    }
                }
                else {
                    while (low < high){
                        if(nums[high-1] == nums[high]){
                            high--;
                        }
                        else {
                            high--;
                            break;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
