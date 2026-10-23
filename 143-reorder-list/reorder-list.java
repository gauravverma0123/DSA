// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     ListNode reverse(ListNode head){
//        ListNode curr = head;
//        ListNode prev = null;
//        while(curr!=null){
//         ListNode fwd = curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=fwd;
//        }
//        return prev;
//     }
//     public void reorderList(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast.next!=null && fast.next.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         ListNode a = head;
//         ListNode b = slow.next;
//         slow.next=null;
//         b=reverse(b);
//         ListNode t1 = a;
//         ListNode t2 = b;
//         while(t2!=null){
//             if(t1.val != t2.val) return false;
//             t1=t1.next;
//             t2=t2.next;
//         }
//         slow.next=reverse(b);
//         //merge a and b alternatively
//         ListNode dummy = new ListNode(-1);
//         ListNode temp = dummy;
//         ListNode temp1 = a;
//         ListNode temp2 = b;
//         while(temp1){//while(temp1!=null)
//             temp.next=temp1;
//             temp=temp.next;
//             temp1=temp1.next;
//             temp.next=temp2;
//             temp=temp.next;
//             if(temp2) temp2=temp2.next;
//         }
//         head = dummy.next;
//     }
// }
class Solution {

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split
        ListNode second = slow.next;
        slow.next = null;

        // Reverse second half
        second = reverse(second);

        // Merge alternately
        ListNode first = head;

        while (second != null) {

            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}