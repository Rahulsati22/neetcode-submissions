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
    public ListNode findMid(ListNode node){
        if (node == null || node.next == null)
            return node;
        ListNode slow = node, fast = node, prev = slow;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
        public ListNode reverse(ListNode head) {
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)return;
        //prev.next = null, return slow
        ListNode secondHalf = findMid(head);
        ListNode reversedSecondHalf = reverse(secondHalf);
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (head != null && reversedSecondHalf != null){
            temp.next = head;
            temp = temp.next;
            head = head.next;

            temp.next = reversedSecondHalf;
            temp = temp.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        if (head != null)
            temp.next = head;
        if (reversedSecondHalf != null)
            temp.next = reversedSecondHalf;
        

        head = ans.next;
    }
}
