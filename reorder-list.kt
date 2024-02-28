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
    fun reorderList(head: ListNode?): Unit {
        var pointer = head
        var pointerFast = head
        while(pointerFast != null){
            pointer = pointer?.next
            pointerFast = pointerFast?.next?.next
        }

        var reversedList : ListNode? = null
        while(pointer != null){
            val temp = pointer.next
            pointer.next = reversedList
            reversedList = pointer
            pointer = temp
        }
        pointer = head
        while(reversedList != null){
            val nextNode = pointer?.next
            pointer?.next = reversedList
            reversedList = reversedList.next
            pointer?.next?.next = nextNode
            pointer = nextNode
        }
        pointer?.next = null
    }
}