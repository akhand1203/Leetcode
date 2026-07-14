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
    List<List<Integer>> res = new ArrayList<>();

    void fun(TreeNode root, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        targetSum = targetSum - root.val;

        if(root.left == null && root.right == null){
            if(targetSum == 0){
                res.add(new ArrayList<>(path));
            }
        } else {
            fun(root.left, targetSum, path);
            fun(root.right, targetSum, path);
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        fun(root, targetSum, new ArrayList<>());
        return res;
    }
}