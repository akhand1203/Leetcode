/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;

    void fun(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if (root == p || root == q) {
            ans = root;
            return;
        }
        int lo = Math.min(p.val, q.val);
        int hi = Math.max(p.val, q.val);

        if (root.val < lo) {
            fun(root.right, p, q);
        } else if (root.val > hi) {
            fun(root.left, p, q);
        } else {
            ans = root;
            return;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fun(root, p, q);
        return ans;
    }
}