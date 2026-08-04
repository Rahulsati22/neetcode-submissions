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
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (node1 != null && node2 != null){
            if (node1.val > node2.val){
                temp.next = node2;
                node2 = node2.next;
            }else{
                temp.next = node1;
                node1 = node1.next;
            }
            temp = temp.next;
        }

        temp.next = node1 != null ? node1 : node2;

        return ans.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++)
           ans = merge(ans, lists[i]);
        
        return ans;
    }
}
