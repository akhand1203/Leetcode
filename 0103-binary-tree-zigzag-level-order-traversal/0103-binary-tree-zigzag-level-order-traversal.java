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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean isLeftToRight = true;

        while (!q.isEmpty()) {

            int lvlSize = q.size();
            List<Integer> tmp = new ArrayList<>();

            while (lvlSize-- > 0) {

                TreeNode t = q.poll();
                tmp.add(t.val);

                if (t.left != null)
                    q.add(t.left);

                if (t.right != null)
                    q.add(t.right);
            }

            if (!isLeftToRight) {
                Collections.reverse(tmp);
            }

            result.add(tmp);

            isLeftToRight = !isLeftToRight;
        }

        return result;
    }
}