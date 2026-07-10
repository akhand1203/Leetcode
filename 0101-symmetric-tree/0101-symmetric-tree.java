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
   boolean fun(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean r1=fun(p.left,q.right);
        boolean r2=fun(p.right,q.left);
        if(r1==true && r2==true){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode p=root.left;
        TreeNode q=root.right;
       return fun(p,q);
    }
}