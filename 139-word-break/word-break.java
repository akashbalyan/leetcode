class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1;i>=0;i--){

                String substr = s.substring(i);
                for(String word:wordDict){
                    if(substr.indexOf(word) == 0 && dp[i+word.length()] == true){
                        dp[i] =true;
                        break;
                    }
                }
        }

        return dp[0];

    
    }
}