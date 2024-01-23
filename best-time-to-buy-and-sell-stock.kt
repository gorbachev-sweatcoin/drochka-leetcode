class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var priceBought = prices[0]
        for(i in prices){
            val profit = i - priceBought

            if(profit < 0){
                priceBought = i
            }else if(profit>maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }
}