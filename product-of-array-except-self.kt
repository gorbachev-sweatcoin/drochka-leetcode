class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }
        var leftProduct = 1
        var rightProduct = 1
        for(i in nums.indices){
            res[i] *= leftProduct
            res[nums.size-i-1] *= rightProduct
            leftProduct*=nums[i]
            rightProduct*=nums[nums.size-i-1]
        }
        return res
    }
}