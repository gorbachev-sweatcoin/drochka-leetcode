class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res = IntArray(temperatures.size) { 0 }
        
        val stack = LinkedList<Int>()
        
        for(i in temperatures.indices.reversed()) {
            while(stack.isNotEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop()
            }

            res[i] = if(stack.isEmpty()){
                0
            } else {
                stack.peek() - i
            }
            stack.push(i)
        }
        return res
    }
}