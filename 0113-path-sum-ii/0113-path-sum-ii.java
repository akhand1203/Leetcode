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

    void fun(TreeNode root, int sum, List<Integer> diary, int target) {
        sum = sum + root.val;
        diary.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(diary));
            }
            diary.remove(diary.size() - 1);
            return;
        }

        if (root.left != null) {
            fun(root.left, sum, diary, target);
        }
        if (root.right != null) {
            fun(root.right, sum, diary, target);
        }

        diary.remove(diary.size() - 1);
        return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        fun(root, 0, new ArrayList<>(), targetSum);
        return res;
    }
}