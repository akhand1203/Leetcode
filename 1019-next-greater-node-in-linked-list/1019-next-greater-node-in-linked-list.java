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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            vals.add(curr.val);
        }

        int n = vals.size();
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && vals.get(stack.peek()) < vals.get(i)) {
                result[stack.pop()] = vals.get(i);
            }
            stack.push(i);
        }

        return result;
    }
}