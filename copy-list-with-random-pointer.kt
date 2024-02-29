/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        val resHead = Node(0)
        var resPointer:Node? = resHead
        var cur = node

        while(cur!=null){
            val nextNode = cur.next
            val copiedNode = Node(cur.`val`)
            copiedNode.next = nextNode
            cur.next = copiedNode
            cur = nextNode
        }

        cur = node 
        while(cur!=null) {
            val copiedNode = cur.next
            copiedNode?.random = cur.random?.next
            cur = cur?.next?.next
        }

        cur = node 
        
        while(cur!=null) {
            val copiedNode = cur.next
            resPointer?.next = copiedNode
            resPointer = resPointer?.next

            cur.next = copiedNode?.next
            cur = cur.next
        }
        
        return resHead.next
    }
}