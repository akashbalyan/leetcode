class Solution {
    public String reverseWords(String s) {
        

        int i =0;
        int len = s.length();
        StringBuilder str = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        
        while(i < len){
            char c = s.charAt(i);
            if(c != ' '){
                str.append(c);
                i++;
            }else{
                if(str.length()>0){
                    stack.push(str.toString());
                    str = new StringBuilder("");
                }
                while(i < len && s.charAt(i) == ' '){
                    i++;
                }
            }
        }
        if(str.length()>0){
            stack.push(str.toString());
        }
        

        StringBuilder resultStr = new StringBuilder("");
        resultStr.append(stack.pop());
        while(!stack.isEmpty()){
            resultStr.append(" ");
            resultStr.append(stack.pop());
        }

        return resultStr.toString();
    }
}