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
        ListNode helper = slow.next;
        slow.next = null;
        return helper;
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
        ListNode rSH = reverse(secondHalf);
        // System.out.println(head.val + " " + rSH.val);

        ListNode helper = head;
        ListNode helper2 = rSH;

        while (helper != null){
            System.out.print(helper.val + " ");
            helper = helper.next;
        }
        System.out.println();
        while (helper2 != null){
            System.out.print(helper2.val + " ");
            helper2 = helper2.next;
        }


        while (head != null && rSH != null){
            ListNode hNext = head.next;
            ListNode rNext = rSH.next;

            head.next = rSH;
            rSH.next = hNext;

            head = hNext;
            rSH = rNext;
        }

        if (head != null)
            System.out.println(head.val);
        if (rSH != null)
            System.out.println(rSH.val);

    }
}


//[2, 4, 6, 8, 10]
