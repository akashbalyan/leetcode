/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        int size = 1;
        while(!q.isEmpty()){
            int count = 0;
            Node current = q.poll();
            if(current.left != null){q.add(current.left);count++;}
            if(current.right != null){q.add(current.right);count++;}
            size--;
            while(size>0){
                
                Node nextNode = q.poll();
                current.next =  nextNode;
                current = nextNode;
                if(current.left != null){q.add(current.left);count++;}
                if(current.right != null){q.add(current.right);count++;}
                size--;
            
            }
            current.next = null;
            size = count;
        }
        return root;
    }
} 