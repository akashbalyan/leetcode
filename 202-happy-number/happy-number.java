class Solution {
    public boolean isHappy(int n) {
        if(n<0) return false;
        HashSet<Integer> set = new HashSet<>();
        int num = sumOfSquares(n);
        while(!set.contains(num)){
            System.out.println(num);
            set.add(num);
            num = sumOfSquares(num);
            
        }

        if(num == 1){
            return true;
        }

        return false;
    }
    private int sumOfSquares(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum = sum + (rem * rem);
            n = n/10;
        }
        return sum;
    }
}