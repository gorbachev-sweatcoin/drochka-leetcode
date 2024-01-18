class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val lookup = hashMapOf<Int,Int>()
        for(i in nums.indices) {
            val secondIndex = lookup[nums[i]]
            if(secondIndex != null){
                return intArrayOf(i,secondIndex)
            } else {
                lookup[target-nums[i]] = i
            }
        }
        return intArrayOf()
    }
}