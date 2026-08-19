/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        nodeQueue.offer(root);
        indexQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = nodeQueue.poll();
                int idx = indexQueue.poll();

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                    indexQueue.offer(2 * idx);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                    indexQueue.offer(2 * idx + 1);
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}