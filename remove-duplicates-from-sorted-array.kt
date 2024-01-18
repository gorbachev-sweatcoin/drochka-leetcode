class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var targetPosition = 0
        for(i in nums.indices) {
            if(nums[i] != nums[targetPosition]){
                nums[++targetPosition] = nums[i]
            }
        }
        return targetPosition+1
    }
}