class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialize base cases
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;  // Cost of deleting characters from word1
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;  // Cost of inserting characters into word1
        }

        // Fill the DP table
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // No cost if characters match
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  // Replace
                                   Math.min(dp[i - 1][j],    // Delete
                                            dp[i][j - 1]));  // Insert
                }
            }
        }

        return dp[len1][len2];
    }
}