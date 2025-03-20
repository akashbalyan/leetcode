class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;
        
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
        // int length1 = s1.length();
        // int length2 = s3.length();
        // if(length1 + length2 != s3.length()){
        //     return false;
        // }

        // boolean arr [][] = new boolean[length1 +1][length2 + 2];
        // arr[arr.length-1][arr[0].length-1] = true;

        // //last row from left to right
        // // for string s2
        // for(int j=arr[0].length-2;j>=0;j--){
        //     arr[arr.length-1][j] = s2.substring(j).equals(s3.substring(s3.length() - s2.length()-j)) ? true : false;
        // }
        // //last column from left to right
        // // for string s1
        // for(int i=arr.length-2;i>=0;i--){
        //     arr[i][arr[0].length-1] = s1.substring(i).equals(s3.substring(s3.length() - s1.length()-i)) ? true : false;
        // }

        // for(int i=arr.length-2;i>=0;i--){
        //     for(int j=arr[0].length-2;j>=0;j--){
        //         boolean ans1 = s1.charAt(i) == s3.charAt(i + j) && arr[i + 1][j];
        //         boolean ans2 = s2.charAt(j) == s3.charAt(i + j) && arr[i][j + 1];
        //         arr[i][j] = ans1 || ans2;
        //     }
        // }
        // return arr[0][0];
    }
}