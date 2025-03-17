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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        if(root == null){
            return ansList;
        }
        q.add(root);
        int size = 1;
        int count = 0;

        while(!q.isEmpty()){
            count =0;
            while(size>0){
                TreeNode node = q.poll();
                size--;
                if(node.left!=null) { q.add(node.left); count++; }
                if(node.right!=null){ q.add(node.right); count++; }

                if(size == 0) ansList.add(node.val);
                
            }
            size = count;
        }
        return ansList;
    }
}