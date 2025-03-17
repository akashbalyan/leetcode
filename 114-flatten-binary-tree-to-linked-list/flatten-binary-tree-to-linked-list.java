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
    public void flatten(TreeNode root) {
        TreeNode node = function(root);

    }
    private TreeNode function(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode ansRoot = root;
        TreeNode leftNode = function(root.left);
        TreeNode rightNode = function(root.right);
        if(leftNode != null){
            root.right = leftNode;
            root.left = null;
            while(root.right!=null){
                root = root.right;
            }
        }
        if(rightNode != null){
            root.right = rightNode;  
        }
        
        
        return ansRoot;

    }
}