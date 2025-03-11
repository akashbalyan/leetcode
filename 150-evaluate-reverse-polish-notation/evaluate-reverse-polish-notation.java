class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(String s:tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ){

                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                if(s.equals("+")){
                    res = num2 +num1;
                }else if(s.equals("-")){
                    res = num2 - num1;
                }else if(s.equals("*")){
                    res = num2 * num1;
                }else if(s.equals("/")){
                    res = num2 / num1;
                }else{

                }
                stack.push(res);
            }else{
                int number = Integer.parseInt(s);
                stack.push(number);
            }
        }

        result = stack.pop();
        return result;
    }
}