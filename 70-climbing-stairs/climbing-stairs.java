class Solution {
    public int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;
        if(n <= 2){
            return n;
        }
        int currentStep = 0;
        for(int i=3;i<=n;i++){
            currentStep = n1 + n2;
            n1 = n2;
            n2 = currentStep;
        }
        return currentStep;
    }
}