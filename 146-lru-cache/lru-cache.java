class LRUCache {

    private int capacity = 0;
    private int capacityUsed = 0;

    HashMap<Integer,Node> map ;

    Node LRU ;
    Node MRU ;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map  = new HashMap<Integer,Node>();
        this.LRU = new Node(0,0);
        this.MRU = new Node(0,0);
        this.LRU.next = this.MRU;
        this.MRU.prev = this.LRU;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){

            Node node = map.get(key);
            //remove from its existing place
            remove(node);
            insert(node);
                // Node prevNode = result.prev;
                // Node nextNode = result.next;

                // prevNode.next = nextNode;
                // nextNode.prev = prevNode;

            //put in front of MRU
            // Node nodeBeforeMRU = MRU.prev;
            // nodeBeforeMRU.next = result;
            // result.prev = nodeBeforeMRU;
            // result.next = MRU;
            // MRU.prev = result;

            return node.value; 
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insert(newNode);

        if(map.size()  > capacity){
            //remove LRU node
            Node LRUnext = LRU.next;
            remove(LRUnext);
            // LRU.next = LRUnext.next;
            // LRUnext.next.prev = LRU;

            //remove LRU node from map
            int LRUnextKey = LRUnext.key;
            map.remove(LRUnextKey);
        
        }


    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = MRU.prev;
        Node next = MRU;
        prev.next = next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    private class Node {
        int key;
        int value;
        Node next = null;
        Node prev = null;

        public Node (int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */