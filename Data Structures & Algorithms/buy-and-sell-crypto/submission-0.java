class Solution {
    public int maxProfit(int[] prices) {
        //we want to buy on a day on which prices are min
        //and we want to sell on the day where prices are max
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            ans = Math.max(prices[i] - min, ans);
        }
        return ans;
    }
}
