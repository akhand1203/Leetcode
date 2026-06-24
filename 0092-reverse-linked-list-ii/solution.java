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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int pos = 1;             
        while (pos < left) {
            prev = curr;
            curr = curr.next;
            pos++;
        }

        
        ListNode leftPrev = prev;   
        ListNode leftNode = curr;    
        ListNode pre = null;
        while (pos <= right) {       
            ListNode nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
            pos++;
        }
        leftNode.next = curr;        
        if (leftPrev != null) {
            leftPrev.next = pre;     
        } else {
            head = pre;
        }
        return head;
    }
}