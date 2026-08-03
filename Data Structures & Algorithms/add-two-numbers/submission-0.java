class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        int carry = 0;

        while (l1 != null && l2 != null){
            int toAdd = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            temp.next = new ListNode(toAdd);
            temp = temp.next;


            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null){
            int toAdd = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;

            temp.next = new ListNode(toAdd);
            temp = temp.next;


            l1 = l1.next;
        }

        while (l2 != null){
            int toAdd = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;

            temp.next = new ListNode(toAdd);
            temp = temp.next;


            l2 = l2.next;
        }

        if (carry != 0)
            temp.next = new ListNode(carry);
        
        return ans.next;
    }
}
