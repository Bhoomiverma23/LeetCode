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
    public int goodNodes(TreeNode root) {
        return helper(root,0,Integer.MIN_VALUE);
    }
    public int helper(TreeNode root,int ans , int currMax){
        if(root == null){
            return 0;
        }
        int currans = 0;
        if(root.val >= currMax){
            currans = 1;
            currMax = root.val;
        }
        int leftans = helper(root.left,ans,currMax);
        int rightans = helper(root.right, ans,currMax);
        return leftans + rightans + currans;
    }
}