class Solution {
    public String predictPartyVictory(String senate) {
        
        Deque<Integer> rDeque = new LinkedList<>();
        Deque<Integer> dDeque = new LinkedList<>();

        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R'){
                rDeque.addFirst(i);
            }else{
                dDeque.addFirst(i);
            }
        }

        while(!rDeque.isEmpty() && !dDeque.isEmpty()){
            int r = rDeque.peekLast();
            int d = dDeque.peekLast();

            if(r < d){
                dDeque.removeLast();
                rDeque.removeLast();
                rDeque.addFirst(r + senate.length());
            }else{
                rDeque.removeLast();
                dDeque.removeLast();
                dDeque.addFirst(d + senate.length());
            }
        }

        if(!rDeque.isEmpty()){
            return "Radiant";
        }

        return "Dire";
    }
}