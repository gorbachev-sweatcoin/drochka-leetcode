class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val sortedIndices = IntArray(position.size) { it }
             .sortedByDescending { position[it] }
        val stack = LinkedList<Pair<Int,Int>>()

        for(i in sortedIndices){
            val pos = position[i]
            val speed = speed[i]

            if(stack.isNotEmpty()) {
                val (pos_top, speed_top) = stack.peek()
                if (speed_top < speed) {
                    if (speed * (pos_top - pos).toDouble() / (speed - speed_top) + pos <= target) {
                        continue
                    }
                }
            }
            stack.push(pos to speed)
        }
        
        return stack.size
    }
}