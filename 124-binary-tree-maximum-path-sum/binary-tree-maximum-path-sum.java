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
    private static int maxSoFar = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int max = function(root);
        int ans = maxSoFar;
        maxSoFar = Integer.MIN_VALUE;
        return ans;
    }
    private int function(TreeNode root ){
            if(root == null){
                return 0;
            }

            int leftMax = Math.max(0,function(root.left));
            int rightMax = Math.max(0,function(root.right));
            
                int sum = leftMax+rightMax+root.val ;
                if(sum > maxSoFar){
                    maxSoFar = sum;
                }
            
            

            return leftMax + root.val >rightMax +root.val ? leftMax+root.val : rightMax+root.val;
        }
}