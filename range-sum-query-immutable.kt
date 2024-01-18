class NumArray(nums: IntArray) {

    val sums = IntArray(nums.size+1) { 0 }

    init {
        for(i in 1..sums.lastIndex){
            sums[i] = sums[i-1] + nums[i-1]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return sums[right+1]-sums[left]
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */