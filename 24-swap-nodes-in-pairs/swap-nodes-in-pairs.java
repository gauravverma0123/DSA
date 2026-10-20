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
       if(head==null || head.next==null) return head;
       ListNode ans = head.next;
       ListNode a = head;
       ListNode prev = null; 
       while(a!=null){
        ListNode b = a.next;
        if(b==null){
            prev.next=a;
            break;
        }
        ListNode fwd = b.next;
        b.next=a;
        if(prev!=null) prev.next = b;
        else head=b;
        prev = a;
        a.next=null;
        a = fwd;
       }
       return ans;
    }
}