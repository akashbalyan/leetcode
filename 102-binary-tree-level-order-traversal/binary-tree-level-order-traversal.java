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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if(root == null){
            return ansList;
        }
        Queue<TreeNode> q = new LinkedList<>();

        int size = 1;
        q.add(root);

        while(!q.isEmpty()){
            

            List<Integer> list = new ArrayList<>();
            int count =0;
            int newSize = 0;
            while(count<size){
                TreeNode node = q.poll();
                list.add(node.val);

                if(node.left!=null) {
                    q.add(node.left);
                    
                    newSize++;
                    }
                if(node.right!=null) {
                    q.add(node.right);
                    newSize++;
                    }

                count++;
            }
            ansList.add(list);
            size = newSize;
        }
        return ansList;
    }
}