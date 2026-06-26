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
    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> used = new HashSet<>();
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (TreeNode tree : trees) {
            map.put(tree.val, tree);
            freq.put(tree.val, freq.getOrDefault(tree.val, 0) + 1);
            if (tree.left != null)
                freq.put(tree.left.val,
                freq.getOrDefault(tree.left.val, 0) + 1);

            if (tree.right != null)
                freq.put(tree.right.val,
                freq.getOrDefault(tree.right.val, 0) + 1);
        }

        TreeNode root = null;
        for (TreeNode tree : trees) {
            if (freq.get(tree.val) == 1) {
                root = tree;
                break;
            }
        }

        if (root == null)
            return null;

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        if (used.size() != trees.size() - 1)
            return null;

        return root;
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        if (node.left == null && node.right == null) {

            if (map.containsKey(node.val) && map.get(node.val) != node) {

                TreeNode temp = map.get(node.val);

                node.left = temp.left;
                node.right = temp.right;

                used.add(temp.val);
            }
        }

        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}