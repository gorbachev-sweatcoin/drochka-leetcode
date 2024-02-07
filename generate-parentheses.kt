class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var res = mutableListOf<String>()
        var str = CharArray(n*2)
        str[n*2-1] = ')'
        dfs(0, 0, str, res)
        return res
    }

    fun dfs(index: Int, opened: Int, str: CharArray, res: MutableList<String>){
        if(index+1==str.size){
            res.add(String(str))
        } else {
            if(index+opened<str.size){
                str[index] = '('
                dfs(index + 1, opened + 1, str, res)
            }
            if(opened>0) {
                str[index] = ')'
                dfs(index + 1, opened - 1, str, res)
            }
        }
    }
}
