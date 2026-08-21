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
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        Map<Integer, Integer> leafCount = new HashMap<>();

        for (TreeNode tree : trees) {
            rootMap.put(tree.val, tree);
            if (tree.left != null) {
                leafCount.merge(tree.left.val, 1, Integer::sum);
            }
            if (tree.right != null) {
                leafCount.merge(tree.right.val, 1, Integer::sum);
            }
        }

        TreeNode root = null;
        for (TreeNode tree : trees) {
            if (!leafCount.containsKey(tree.val)) {
                root = tree;
                break;
            }
        }

        if (root == null) return null;

        rootMap.remove(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE, rootMap) || !rootMap.isEmpty()) {
            return null;
        }

        return root;
    }

    private boolean dfs(TreeNode node, long low, long high, Map<Integer, TreeNode> rootMap) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;

        if (node.left == null && node.right == null && rootMap.containsKey(node.val)) {
            TreeNode merged = rootMap.remove(node.val);
            node.left = merged.left;
            node.right = merged.right;
        }

        return dfs(node.left, low, node.val, rootMap) && dfs(node.right, node.val, high, rootMap);
    }
}