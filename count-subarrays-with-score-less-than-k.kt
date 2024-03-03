class Solution {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        if(nums.size==1) return if(nums[0]<k) 1 else 0

        var sum = 0L
        val prefixSum = LongArray(nums.size+1) { index ->
            if(index>0){
                sum += nums[index-1]
            }
            sum
        }
        var l = 0
        var r = 1

        var result = 0L
        while(r<prefixSum.size) {
            val score = (prefixSum[r]-prefixSum[l]) * (r-l)
            if (score<k) {
                result += r-l
                r++
            } else {
                l++
                if(r<l) {
                    r = l + 1 
                }
            }
        }
        return result
    }
}