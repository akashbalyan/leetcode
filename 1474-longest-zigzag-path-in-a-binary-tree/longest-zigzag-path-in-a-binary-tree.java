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
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
    
        dfs(root.right,"right",1);
        dfs(root.left,"left",1 );

        return maxLen;
    }

    private void dfs(TreeNode root, String prevDirection, int currentSteps){
        if(root == null){
            return;
        }
        maxLen = Math.max(maxLen,currentSteps);
        if(prevDirection.equals("left")){
             dfs(root.right,"right",currentSteps +1);
             dfs(root.left,"left",1);
        }else{
            dfs(root.left,"left",currentSteps +1);
            dfs(root.right,"right",1);
        }

        return ;
    }
}