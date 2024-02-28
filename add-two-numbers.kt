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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = l1
        var second = l2
        val res = ListNode(0)
        var resPointer = res
        var carry = 0
        while(first != null || second != null || carry != 0){
            val sum = (first?.`val` ?: 0) + (second?.`val` ?: 0) + carry
            carry = sum / 10
            resPointer.next = ListNode(sum % 10)
            resPointer = resPointer.next
            first = first?.next
            second = second?.next
        }
        return res.next
    }
}