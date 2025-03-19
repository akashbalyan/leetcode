class Solution {
    public int minPathSum(int[][] grid) {
        int arr [][] = new int[grid.length][grid[0].length];

        //bottom value
        arr[arr.length-1][arr[0].length - 1] = grid[arr.length-1][arr[0].length - 1];

        //fill last row
        for(int j=arr[0].length-2;j>=0;j--){
            arr[arr.length-1][j] = grid[arr.length-1][j] + arr[arr.length-1][j+1];
        }

        //fill last column
        for(int i=arr.length-2;i>=0;i--){
            arr[i][arr[0].length-1] = grid[i][arr[0].length-1] + arr[i+1][arr[0].length-1];
        }

        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr[0].length-2;j>=0;j--){
                arr[i][j] = grid[i][j] + Math.min(arr[i+1][j],arr[i][j+1]);
            }
        }
        return arr[0][0];
    }
}