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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftsum = 0;
         if (root.left != null && root.left.left == null && root.left.right == null) {
            leftsum += root.left.val;
        }
        leftsum += sumOfLeftLeaves(root.left);
        leftsum += sumOfLeftLeaves(root.right);
        return leftsum;
    }
}