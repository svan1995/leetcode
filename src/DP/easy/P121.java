package DP.easy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票
 */



public class P121 {
    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length];
        max[1] = prices[1] - prices[0];
        int min;
        if (prices[0] < prices[1])
            min = prices[0];
        else
            min = prices[1];
        for (int i=2; i<prices.length; i++){
            max[i] = (max[i-1] > (prices[i] - min))?max[i-1]:(prices[i]-min);
            if (prices[i] < min)
                min = prices[i];

        }
        return max[max.length-1];
    }
}
