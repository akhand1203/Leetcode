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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixCount) {
        if (node == null) return 0;

        currSum += node.val;
        int count = prefixCount.getOrDefault(currSum - targetSum, 0);

        prefixCount.merge(currSum, 1, Integer::sum);

        count += dfs(node.left, currSum, targetSum, prefixCount);
        count += dfs(node.right, currSum, targetSum, prefixCount);

        prefixCount.merge(currSum, -1, Integer::sum);

        return count;
    }
}