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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode forward = head, backward = head, prev = null;
        while (n-- != 1){
            forward = forward.next;
        }

        if (forward.next == null)return head.next;

        while (forward.next != null){
            prev = backward;
            forward = forward.next;
            backward = backward.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
