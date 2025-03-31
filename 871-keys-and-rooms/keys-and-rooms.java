class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean visited [] = new boolean [rooms.size()];
        // visited[0] = true;

        visitRooms(0,rooms,visited);

        
        for(boolean b:visited){
            if(b == false){
                return false;
            }
        }
        return true;
    }

    private void visitRooms(int currentRoom,List<List<Integer>> listOfRooms,boolean visited[]){
        if(visited[currentRoom]) return;

            visited[currentRoom] = true;
            for(int roomKey:listOfRooms.get(currentRoom)){
                visitRooms(roomKey,listOfRooms,visited);
            }
            return ;
    }
}