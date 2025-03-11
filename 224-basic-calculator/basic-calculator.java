class Solution {
    public int calculate(String s) {
        
        int ans = 0;
        int currentNumber = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign =1;
                i++;
            }else if(c  == '+'){
                sign = 1;
                i++;
            }else if(c == '-'){
                sign = -1;
                i++;
            }else if(c == ')'){
                int stackSign = stack.pop();
                int stackAns = stack.pop();
                ans =  stackAns + (stackSign * ans);
                i++;
            }else if(c == ' '){
                i++;
            }
            else{
                int multiplier = 10;
                currentNumber = 0;
                while(i<s.length() && !(s.charAt(i) == ' ' ||
                 s.charAt(i) == '+' ||
                 s.charAt(i) == '-' || 
                 s.charAt(i) == ')' ||
                 s.charAt(i) == '(')){
                    int num = s.charAt(i) -'0';
                    currentNumber = (currentNumber * multiplier) + num;
                    //multiplier = multiplier * 10;
                    i++;
                    System.out.println(currentNumber);
                 }
                 ans = ans + (sign * currentNumber);
                 
                
            }
        }

        return ans;
    }
}