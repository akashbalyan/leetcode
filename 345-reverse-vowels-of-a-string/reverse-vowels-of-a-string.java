class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder("");
        for(char chr:s.toCharArray()){
            if(isVowel(chr)){
                vowels.append(chr);
            }
            
        }
    StringBuilder res = new StringBuilder("");
    int j = 0;
        for(int i=s.length()-1;  i>=0;i--){
                if(isVowel(s.charAt(i))){
                    res.append(vowels.charAt(j));
                    j++;
                }else{
                    res.append(s.charAt(i));
                }
        }
    return res.reverse().toString();
        
    }

    private boolean isVowel(char chr){
        char c = chr;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
                    return true;
                   }
                   return false;

    }
}