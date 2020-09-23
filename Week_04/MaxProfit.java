package leetcode.week_04;

import org.junit.Test;

/**
 * 买卖股票的最大收益Ⅱ
 * 贪心
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        //思路
        //遍历数组中的元素，如果下一个元素大于当前元素，则买入当前股票，并在下一个元素卖出，收益是下一个元素与当前元素的差值
        if (prices == null) {
            return 0;
        }
        int count = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (i == 0) {
                continue;
            }
            if (prices[i] > prices[i - 1]) {
                count += prices[i] - prices[i - 1];
            }
        }
        return count;
    }

    @Test
    public void testMaxProfit() {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }


    public int maxProfitV2(int[] prices) {
        //题解中的答案，写得更简洁些
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

}
