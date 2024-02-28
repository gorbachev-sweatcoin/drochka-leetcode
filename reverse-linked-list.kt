/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var current = head
        while(current != null){
            val temp = current.next
            current.next = newHead
            newHead = current
            current = temp
        }
        return newHead
    }
}