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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var first = list1
        var second = list2
        val newHead = ListNode()
        var current = newHead
        while(first !=null && second != null){
            if(first.`val` < second.`val`) {
                current.next = first
                first = first.next
            } else {
                current.next = second
                second = second.next
            }
            current = current.next
        }
        if(first != null){
            current.next = first
        } else {
            current.next = second
        }
        return newHead.next
    }
}