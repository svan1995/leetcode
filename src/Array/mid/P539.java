package Array.mid;
//最小时间差
//给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
//
//
//        示例 1：
//
//        输入: ["23:59","00:00"]
//        输出: 1
//
//        备注:
//
//        列表中时间数在 2~20000 之间。
//        每个时间取值在 00:00~23:59 之间。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/minimum-time-difference
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P539 {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = toMinute(timePoints.get(i));
        }
        Arrays.sort(arr);
        int first = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) {
                arr[i] = first + 24*60 - arr[i];
            }else {
                arr[i] = arr[i+1] - arr[i];
            }
        }
        Arrays.sort(arr);
        return arr[0];

    }


    private int toMinute(String str){
        String hour = str.substring(0, str.indexOf(":"));
        String min = str.substring(str.indexOf(":")+1);
//        System.out.println(hour);
//        System.out.println(min);
        return toNum(hour)*60 + toNum(min);

    }

    private int toNum(String str){
        if (str.charAt(0) == '0'){
            return Integer.parseInt(str.substring(1));
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        P539 p539 = new P539();
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("23:59");
        System.out.println(p539.findMinDifference(list));
    }
}
