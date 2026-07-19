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
    List<TreeNode> nodes = new ArrayList<>();
    void fun(TreeNode root){
        if(root==null){
            return;
        }
        nodes.add(root);
        fun(root.left);
        fun(root.right);
    }
    public void flatten(TreeNode root) {
        fun(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            TreeNode curr = nodes.get(i);
            TreeNode next = nodes.get(i + 1);
            curr.left = null;
            curr.right = next;
        }
    }
}