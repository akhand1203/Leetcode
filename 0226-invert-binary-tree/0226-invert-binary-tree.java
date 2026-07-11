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
    void fun(TreeNode root){
    if(root==null){
        return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    fun(root.left);
    fun(root.right);
    return;
}
    public TreeNode invertTree(TreeNode root) {
        fun(root);
        return root;
    }
}