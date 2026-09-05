/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode newHead = head.next;
        ListNode curr = null;
        ListNode temp = new ListNode(-1);
        while (prev != null && prev.next != null) {
            curr = prev.next;
            temp.next = curr; 
            prev.next = curr.next;
            curr.next = prev;
            temp = prev;
            prev = prev.next;

        }
        return newHead;  
    }
}