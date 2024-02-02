class Solution {
    
    fun largestRectangleArea(heights: IntArray): Int {    
        var maxArea = 0
        val stack = LinkedList<Int>()
        for(i in heights.indices) {
            while(stack.isNotEmpty() && heights[stack.peek()] > heights[i]) {
                val leftmostBarHeight = heights[stack.pop()]
                val leftmostIndex = if(stack.isNotEmpty()) stack.peek() + 1 else 0
                maxArea = max(maxArea, (i - leftmostIndex) * leftmostBarHeight)
            }
            stack.push(i)
        }
        while(stack.isNotEmpty()) {
            val leftmostBarHeight = heights[stack.pop()]
            val leftmostIndex = if(stack.isNotEmpty()) stack.peek() + 1 else 0
            maxArea = max(maxArea, (heights.size - leftmostIndex) * leftmostBarHeight)
        }
        return maxArea
    }
}