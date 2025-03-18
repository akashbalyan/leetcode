class Solution {

    class Node{
        String divisor ;
        double value;

        public Node(String divisor,double value){
            this.divisor = divisor;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        //create a directed graph 
        HashMap<String,ArrayList<Node>> map = new HashMap<>();

        int count =0;

        for(List<String> list:equations){
            String num = list.get(0);
            String denom = list.get(1);
            double value = values[count];
            count++;
            if(!map.containsKey(num)){
                ArrayList<Node> list_ = new ArrayList<>();
                Node node = new Node(denom,value);
                list_.add(node);
                map.put(num,list_);
            }else{
                ArrayList<Node> list_ = map.get(num);
                Node node = new Node(denom,value);
                list_.add(node);
                map.put(num,list_);
            }
            if(!map.containsKey(denom)){
                ArrayList<Node> list_ = new ArrayList<>();
                Node node = new Node(num,1/value);
                list_.add(node);
                map.put(denom,list_);
            }else{
                ArrayList<Node> list_ = map.get(denom);
                Node node = new Node(num,1/value);
                list_.add(node);
                map.put(denom,list_);
            }
        }
        double result[] = new double[queries.size()];
        //BFS or DFS through graph and store result
        count =0;

        for(List<String> list:queries){
            String num = list.get(0);
            String denom = list.get(1);
            double value = 0;
    
                HashSet<String> visited = new HashSet<>();
                value = DFS(num,denom,map,visited);
            

            result[count ]= value;
            count++;
        }
        return result;
    }

        private double DFS(String num, String denom, HashMap<String, ArrayList<Node>> map, HashSet<String> visited) {
        if (!map.containsKey(num) || !map.containsKey(denom)) return -1.0;  // Base case: If either number is missing

        if (num.equals(denom)) return 1.0;  // If we reach the target, return 1

        visited.add(num);  // Mark the current node as visited

        ArrayList<Node> list = map.get(num);
        for (Node node : list) {
            if (!visited.contains(node.divisor)) {  // Check if the node was already visited
                double result = DFS(node.divisor, denom, map, visited);
                if (result != -1.0) {
                    return node.value * result;  // Multiply values along the path
                }
            }
        }
        
        return -1.0;  // Return -1 if no path found
    }
    // private double DFS(String num,String denom, HashMap<String,ArrayList<Node>> map ){
        
    //     ArrayList<Node> list = map.get(num);
    //     for(Node node:list){
    //         if(node.divisor.equals(denom)){
    //             return node.value;
    //         }else{
    //             return node.value * DFS(node.divisor,denom,map);
    //         }
    //     }
    //     return -1;
    // }
}