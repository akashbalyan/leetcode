/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        // Step 1: Create a map from original nodes to new nodes
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        // First pass: Clone each node (only value) and store in map
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Assign next and random pointers
        current = head;
        while (current != null) {
            Node clonedNode = map.get(current);
            clonedNode.next = map.get(current.next);   // Link cloned next
            clonedNode.random = map.get(current.random); // Link cloned random
            current = current.next;
        }

        // Return head of cloned linked list
        return map.get(head);
    }
}