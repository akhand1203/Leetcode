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
    boolean res=false;
    void fun(TreeNode root, int targetSum ,int sum){
        if(root==null){
            return;
        }
        sum=sum+root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                res=true;
            }
            return;
        }
        fun(root.left,targetSum,sum);
        fun(root.right,targetSum,sum);
        return;

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        fun(root,targetSum,0);
        return res;
    }
}