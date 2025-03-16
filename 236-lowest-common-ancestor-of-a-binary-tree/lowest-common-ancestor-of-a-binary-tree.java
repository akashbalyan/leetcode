/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //   if (root == null) return null;
        
        // // If both p and q are smaller than root, LCA must be in the left subtree
        // if (p.val < root.val && q.val < root.val) {
        //     return lowestCommonAncestor(root.left, p, q);
        // }

        // // If both p and q are greater than root, LCA must be in the right subtree
        // if (p.val > root.val && q.val > root.val) {
        //     return lowestCommonAncestor(root.right, p, q);
        // }

        // // If p and q are on different sides (or one of them is root), root is LCA
        // return root;
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}