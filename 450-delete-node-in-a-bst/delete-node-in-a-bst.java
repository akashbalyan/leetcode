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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val == key){
            if(root.right == null){
                return root.left;
            }else{
                TreeNode node = root.right;
                while(node.left!=null){
                    node = node.left;
                }
                node.left = root.left;
                root.left = null;
                return root.right;
            }
        }
        root.right = deleteNode(root.right,key);
        root.left = deleteNode(root.left,key);
        return root;
    }
}