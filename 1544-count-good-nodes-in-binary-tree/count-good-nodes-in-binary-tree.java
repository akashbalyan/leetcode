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
        int maxSoFar = Integer.MIN_VALUE;
        return dfs(root, maxSoFar);
    }
    private int dfs(TreeNode root, int maxSoFar){
        if(root == null){
            return 0;
        }

        int result = 0;
        if(root.val >= maxSoFar){
            result++;
            maxSoFar = root.val;
        }
        return result + dfs(root.left,maxSoFar) + dfs(root.right,maxSoFar);
    }
}