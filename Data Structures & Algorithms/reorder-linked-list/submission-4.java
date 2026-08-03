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
        ListNode secondHalf = findMid(head);
        ListNode rSH = reverse(secondHalf);

        while (rSH != null){
            ListNode hNext = head.next;
            ListNode rNext = rSH.next;

            head.next = rSH;
            rSH.next = hNext;

            head = hNext;
            rSH = rNext;
        }
    }
}
