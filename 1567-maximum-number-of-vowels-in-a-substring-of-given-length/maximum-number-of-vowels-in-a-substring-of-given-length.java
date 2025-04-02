class Solution {
    public int maxVowels(String s, int k) {
        int start = 0;
        int end = 0;
        int maxCountSoFar = 0;
        int vowelCount =0;
        while(end<k){
            if(isVowel(s.charAt(end))){
                vowelCount++;
            }
            end++;
            maxCountSoFar = Math.max(maxCountSoFar,vowelCount);
        }
         while(end<s.length()){
            if(isVowel(s.charAt(start))){
                vowelCount--;
            }
            if(isVowel(s.charAt(end))){
                vowelCount++;
            }
            maxCountSoFar = Math.max(maxCountSoFar,vowelCount);
            start++;
            end++;
        }
        return maxCountSoFar;
        
    }
    private boolean isVowel(char c){
        if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ){
            return true;
        }
        return false;
    }
}