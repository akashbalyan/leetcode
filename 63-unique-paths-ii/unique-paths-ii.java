class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }
        int arr [][] = new int[obstacleGrid.length][obstacleGrid[0].length];

        //bottom value
        arr[arr.length-1][arr[0].length - 1] = 1;

        //fill last row
        for(int j=arr[0].length-2;j>=0;j--){
            arr[arr.length-1][j] = obstacleGrid[arr.length-1][j] == 1? 0: arr[arr.length-1][j+1];
        }

        //fill last column
        for(int i=arr.length-2;i>=0;i--){
            arr[i][arr[0].length-1] = obstacleGrid[i][arr[0].length-1] == 1? 0: arr[i+1][arr[0].length-1];
        }

        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr[0].length-2;j>=0;j--){
                // int right = arr[i][j+1] != -1 ? arr[i][j+1] : 0;
                // int down = arr[i+1][j] != -1 ? arr[i+1][j] : 0;
                arr[i][j] = obstacleGrid[i][j] == 0 ? arr[i][j+1] + arr[i+1][j] : 0; 
            }
        }
        return arr[0][0];
    }
}