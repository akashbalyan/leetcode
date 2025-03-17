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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = 1;
        //odd left to right
        //even right to left
        ArrayList<List<Integer>> ansList = new ArrayList<>();
        if(root == null){
            return ansList;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int size = 1;
        int count = 0;

        while(!q.isEmpty()){
            count = 0;
            ArrayList<Integer> nodesList = new ArrayList<>();

            while(size>0){
                TreeNode node = q.poll();
                
                size--;
                if(level %2 != 0){
                    nodesList.add(node.val);
                }else{
                    nodesList.add(0,node.val);
                }
                if(node.left!=null) { q.add(node.left);count++;}
                if(node.right!=null) { q.add(node.right);count++;}
            }
            ansList.add(nodesList);
            size = count;
            level++;
        }
        return ansList;
    }
}