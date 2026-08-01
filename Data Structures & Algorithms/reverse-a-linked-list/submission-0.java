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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode start = head, prev = null, next = head.next;
        while (start != null){
            start.next = prev;
            prev = start;
            start = next;
            if (next != null)
                next = next.next;
        }
        return prev;
    }
}
