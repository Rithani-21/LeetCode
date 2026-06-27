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
        // If the list is empty or has only one node, no swaps are needed
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize a dummy node to maintain the new head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Traverse the list as long as there is a pair to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Re-point the links to perform the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move the prev pointer forward by two nodes for the next pair
            prev = first;
        }
        
        return dummy.next;
    }
}