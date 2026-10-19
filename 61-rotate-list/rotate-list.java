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
    int length(ListNode head){
        int len =0 ;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int n =length(head);
        k = k%n;
        if(k==0) return head;
        ListNode a = null;//k+1th from end
        ListNode b = null;//kth from end
        ListNode c = null;//last node
        ListNode temp=head;
        for(int i=1;i<=n;i++){
            if(i==n-k) a = temp;
            if(i==n-k+1) b = temp;
            if(i==n) c = temp;
            temp=temp.next;
        }
        a.next=null;
        c.next=head;
        return b;
    }
}