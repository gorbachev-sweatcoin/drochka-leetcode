class Solution {
    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char>()
        for(i in s.indices){
            when(s[i]){
                '(', '{', '[' -> stack.push(s[i])
                else -> if(stack.isEmpty() || !sameTypeButClosed(stack.pop(), s[i])){
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

    fun sameTypeButClosed(opened: Char, closed: Char): Boolean{
        return (opened == '(' && closed == ')') ||
            (opened == '{' && closed == '}') || 
            (opened == '[' && closed == ']') 
    }
}