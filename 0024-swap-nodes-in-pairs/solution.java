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
    void reverse(ListNode head, int times) {
        ListNode curr = head;
        ListNode prev = null;
        while (times-- > 0) {
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode left = head;
        ListNode right = null;
        ListNode res = null;
        ListNode prevleft = null;
        int size = 2;
        while (true) {
            right = left;
            for (int i = 0; i < size - 1; i++) {
                if (right == null)
                    break;
                right = right.next;
            }
            if (right != null) {
                ListNode nextleft = right.next;
                reverse(left, size);
                if (prevleft != null) {
                    prevleft.next = right;
                } else {
                    res = right;
                }
                prevleft = left;
                left = nextleft;
            } else {
                if (prevleft != null) {
                    prevleft.next = left;
                }
                if (res == null) {
                    res = left;
                }
                break;
            }
        }
        return res;
    }
}