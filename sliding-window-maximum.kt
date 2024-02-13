class Solution {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if(nums.size == k) {
            return intArrayOf(nums.max())
        } else if (k == 1) {
            return nums
        }

        var result = IntArray(nums.size-k+1) { 0 }
        val deque = LinkedList<Int>()
        for(i in nums.indices){
            while(deque.isNotEmpty() && nums[deque.last()] < nums[i]) deque.removeLast()
            deque.add(i)
            if (deque.first() <= i - k) deque.removeFirst()
            if (i >= k-1) {
                result[i-k+1] = nums[deque.first()]
            }
        }
        return result
    }
}