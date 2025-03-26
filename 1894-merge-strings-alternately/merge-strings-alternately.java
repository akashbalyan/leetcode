class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder("");
        int i=0;
        int j=0;
        int len1 = word1.length();
        int len2 = word2.length();

        while(i<len1 && j <len2){
            str.append(word1.charAt(i));i++;
            str.append(word2.charAt(j));j++;
        }
        while(i<len1){
            str.append(word1.charAt(i));
            i++;
        }
         while(j<len2){
            str.append(word2.charAt(j));
            j++;
        }

        return str.toString();
    }
}