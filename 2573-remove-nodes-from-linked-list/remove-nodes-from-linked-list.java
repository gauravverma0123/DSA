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
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            while(st.size()>0 && temp.val > (st.peek().val))
            st.pop();
            st.push(temp);
            temp=temp.next;
        }
        ListNode dummy = new ListNode(-1);
        temp=dummy;
        while(st.size()>0){
            ListNode top = st.peek();
            st.pop();
            temp.next=top;
            temp=top;
        }
        temp.next=null;//very importent cycle can form;
        return reverse(dummy.next);
    }
}