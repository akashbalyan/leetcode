class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    stack.pop(); // top explodes, keep checking
                } else if (top == -asteroid) {
                    stack.pop(); // both explode
                    destroyed = true;
                    break;
                } else {
                    // current asteroid explodes
                    destroyed = true;
                    break;
                }
            }
            
            if (!destroyed) {
                stack.push(asteroid);
            }
        }
        
        // convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

