/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        return cloneGraph2(node,map);
    }
    public Node cloneGraph2(Node node,HashMap<Node,Node> map) {
        if(node == null){
            return null;
        }
        Node ansNode;
        if(!map.containsKey(node)){
            ansNode = new Node(node.val);
            map.put(node,ansNode);
        }else{
            return map.get(node);
        }
        List<Node> neighborsList = new ArrayList<>();
        for(Node n:node.neighbors){
            Node neighborNode = cloneGraph2(n,map);
            neighborsList.add(neighborNode);

        }
        ansNode.neighbors = neighborsList;

        return ansNode;
    }
}