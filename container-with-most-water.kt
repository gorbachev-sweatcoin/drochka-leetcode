class Solution {

    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var l = 0
        var r = height.size - 1

        while (l<r) {
            maxArea = max(maxArea, min(height[l],height[r]) * (r-l))
            
            if(height[l]<height[r]){
                l++
            }else{
                r--
            }
        }
        
        return maxArea
    }
}