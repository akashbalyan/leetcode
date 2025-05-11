class Solution {
    public int compress(char[] chars) {
        int i =0;
        int len = chars.length;

        StringBuilder resultString = new StringBuilder("");
        while(i < len){
            char c = chars[i];
            int count = 1;
            i++;
            while(i < len && chars[i] == c){
                i++;
                count++;
            }
            resultString.append(c);
            if(count >1){
                resultString.append(count);
            }
        }
        for(i=0;i<resultString.length();i++){
            chars[i] = resultString.charAt(i);
        }
        return resultString.toString().length();
    }
}