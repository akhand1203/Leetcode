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
    private int cameras = 0;
    private static final int NOT_COVERED = 0;
    private static final int COVERED = 1;
    private static final int HAS_CAMERA = 2;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == NOT_COVERED) {
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) return COVERED;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == NOT_COVERED || right == NOT_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }

        if (left == HAS_CAMERA || right == HAS_CAMERA) {
            return COVERED;
        }

        return NOT_COVERED;
    }
}