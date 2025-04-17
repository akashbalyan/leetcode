class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n= grid[0].length;
        int freshOranges = 0;
        int num =0;

        // queue to store rotten oranges  
        Queue<int[]> queue = new LinkedList<>();

        //itereate through 2d array to store rotten and fresh oranges
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] ==2){
                    queue.offer(new int[] {i,j});
                }
                if(grid[i][j] == 1){
                    freshOranges+=1;
                }
            }
        }

        //store directions here
        int directions [][] = {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        while(!queue.isEmpty() && freshOranges >0){
            int size = queue.size();
            for(int i=0;i<size;i++){

                //current rotten Orange Node
                int rottenNode[] = queue.poll();
                int x = rottenNode[0];
                int y = rottenNode[1];

                //go through all the directions
                for(int dir[] :directions){
                    int newX = x +dir[0];
                    int newY = y +dir[1];

                    if(newX >= 0 && newX <m
                    && newY >=0 && newY <n 
                    && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        freshOranges--;
                        queue.add(new int[]{newX,newY});
                    }
                }
                

            }
            num = num+1;

            
        }

    return freshOranges == 0 ? num : -1;
    }
}