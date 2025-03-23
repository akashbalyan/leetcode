class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        
        int[][] dp = new int[len1 ][len2 ];

        int maxLenSoFar = 0;
        // Initialize base cases
        for (int i = 0; i < len1; i++) {
            dp[i][len2-1] = matrix[i][len2-1] == '1' ? 1 : 0; 
            maxLenSoFar = Math.max(maxLenSoFar,dp[i][len2-1]);
        }
        for (int j = 0; j < len2; j++) {
            dp[len1-1][j] = matrix[len1-1][j] == '1' ? 1 : 0;  
            maxLenSoFar = Math.max(maxLenSoFar,dp[len1-1][j]); 
        }

        
        // Fill the DP table
        for (int i = len1 -2; i >= 0; i--) {
            for (int j = len2-2; j >=0; j--) {
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min ( Math.min(dp[i+1][j+1],dp[i][j+1]) , dp[i+1][j]) + 1;
                    maxLenSoFar = Math.max(maxLenSoFar,dp[i][j]);
                }
            }
        }

        return maxLenSoFar * maxLenSoFar;
    }
}