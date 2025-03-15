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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

    HashMap<Integer,Integer> map =  new HashMap<>();
    int count =0;
    for(int i:inorder){
        map.put(i,count++);
    }

   TreeNode result =  function(inorder,0,inorder.length-1,postorder,postorder.length-1,map);
    return result;
    }

    private TreeNode function(int [] inorder ,int start,int end,int[] postorder,int rootIndex, HashMap<Integer,Integer> map){
        if(start>end || end<start){
            return null;
        }
        TreeNode root = new TreeNode(postorder[rootIndex]);
        if(start == end){
            return root;
        }
        int rootIndexInInorder = map.get(postorder[rootIndex]);


        root.left = function(inorder,start,rootIndexInInorder-1,postorder, rootIndex - (end-rootIndexInInorder) - 1, map);
        root.right = function(inorder, rootIndexInInorder+1,end,postorder,rootIndex-1,map);
        return root;
    }
}