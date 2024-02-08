class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var right = piles.max()
        var left = 1

        while(left<right) {
            var mid = left + (right - left)/2
            var totalHours = 0
            for(i in piles){
                totalHours += if(i%mid==0) {
                    i / mid 
                } else { 
                    i / mid + 1 
                }
                if(totalHours>h) break
            }
            if(totalHours>h) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return right
    }
}