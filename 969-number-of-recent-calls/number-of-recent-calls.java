class RecentCounter {

    Queue<Integer> q;
    int t ;
    public RecentCounter() {
         this.q = new LinkedList<>();
         this.t = 0;
    }
    
    public int ping(int t) {
        if(q.size() == 0){
            q.add(t);
            this.t = t-3000;
            return 1;
        }else{
            q.add(t);
            this.t = t-3000;

            //System.out.println(q);
            while(!q.isEmpty() && q.peek() < this.t){
                
                q.remove();
                
            }
            return q.size();
        }
    }

    


}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */