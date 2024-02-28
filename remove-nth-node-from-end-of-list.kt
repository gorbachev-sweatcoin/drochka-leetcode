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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val newHead = ListNode(0)
        newHead.next = head
        var removingPointer = newHead
        var pointer = head
        var i = 0
        while(pointer != null){
            if(i==n) {
                removingPointer = removingPointer!!.next
            }else{
                i++
            }
            pointer = pointer?.next
        }
        removingPointer?.next = removingPointer?.next?.next
        return newHead.next
    }
}