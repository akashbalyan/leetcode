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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        int count = 0;
        int level = 1;
        int maxSumSoFar = Integer.MIN_VALUE;
        int maxLevelSoFar = 1;
        while(!q.isEmpty()){
            int sum = 0;
            count = 0;
            while(size>0){
                TreeNode node = q.poll();
                sum+=node.val;
                TreeNode left = node.left;
                TreeNode right = node.right;

                if(left != null){
                    count++;
                    q.add(left);
                }
                if(right != null){
                    count++;
                    q.add(right);
                }
                size--;
            }
            if(sum > maxSumSoFar){
                maxSumSoFar = sum;
                maxLevelSoFar = level;
            };
            level++;
            size = count;

        }


        return maxLevelSoFar;
    }
}