class Solution {
    
    fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
        var sum = 0
        var startIndex = -1
        var fruitsOnStartPos = 0
        for(i in fruits.indices){
            if(fruits[i][0]<startPos) {
                sum+=fruits[i][1]
            } else if (fruits[i][0]==startPos) {
                fruitsOnStartPos = fruits[i][1]
            } else {
                break
            }
            startIndex = i
        }
        
        val prefixShit = IntArray(fruits.size) { index ->
            when {
                fruits[index][0] < startPos -> sum.also { sum -= fruits[index][1] }
                fruits[index][0] == startPos -> 0
                else -> (sum + fruits[index][1]).also { sum = it }
            }
        }

        var maxFruits = 0

        // going left
        if (startIndex>=0) {
            var rightmostFruit = fruits.size - 1
            for(i in startIndex downTo 0) {
                val leftPosition = fruits[i][0]
                val stepsAvailiable = k - (startPos - leftPosition)
                if (stepsAvailiable < 0) break
                while(rightmostFruit > startIndex && stepsAvailiable < fruits[rightmostFruit][0] - leftPosition) rightmostFruit--
                maxFruits = if(rightmostFruit > startIndex){
                    max(maxFruits, prefixShit[i] + prefixShit[rightmostFruit])
                } else {
                    max(maxFruits, prefixShit[i])
                }
            }
        }
        // going right
        if (startIndex + 1 < fruits.size) {
            var leftmostFruit = 0
            for(i in (startIndex+1) until fruits.size) {
                val rightPosition = fruits[i][0]
                val stepsAvailiable = k - (rightPosition - startPos)
                if (stepsAvailiable < 0) break
                while(leftmostFruit <= startIndex && stepsAvailiable < rightPosition - fruits[leftmostFruit][0]) leftmostFruit++

                maxFruits = if(leftmostFruit <= startIndex){
                    max(maxFruits, prefixShit[i] + prefixShit[leftmostFruit])
                } else {
                    max(maxFruits, prefixShit[i])
                }
            }
        }

        return maxFruits + fruitsOnStartPos
    }
}