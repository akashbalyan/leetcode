class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        for(int conn[] : connections){

            set.add(conn[0] + "," + conn[1]);

            map.computeIfAbsent(conn[0], k -> new HashSet<>()).add(conn[1]);
            map.computeIfAbsent(conn[1], k -> new HashSet<>()).add(conn[0]); 
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        boolean visited[] = new boolean[n];
        visited[0] = true;
        int res = 0;
        
        while(!q.isEmpty()){
            
            int current = q.poll();
            for(int neighbor: map.getOrDefault(current, new HashSet<>())){
                if(visited[neighbor]) continue;
                visited[neighbor] = true;
                if(!set.contains(neighbor + "," + current)){
                    res++;
                }
                q.offer(neighbor);
            }
        }


        return res;
    }
}