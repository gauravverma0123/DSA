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
        ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode i = list1;
        ListNode j = list2;
        ListNode k = dummy;
        while(i != null && j!=null){
            if(i.val < j.val){
                k.next=i;
                i=i.next;
            } else {
                k.next=j;
                j=j.next;
            }
            k=k.next;
        }
        if(i==null) k.next=j;
        else k.next=i;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        // Break the list into 2 half
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        // at this point, slow is at left middle/middle
        ListNode head2 = slow.next;
        slow.next = null;
        head=sortList(head);
        head2=sortList(head2);
        return mergeTwoLists(head,head2);
    }
}