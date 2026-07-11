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
    TreeNode ans = null;

    void fun(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            ans = root;
            return;
        }
        if (root.val > val) {
            fun(root.left, val);
        } else {
            fun(root.right, val);
        }
        return;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        fun(root, val);
        return ans;
    }
}