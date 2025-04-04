class Solution {
    public int longestOnes(int[] nums, int k) {
        int start =0;
        int end = 0;
        int ones = 0;
        int zeros = 0;
        int maxSoFar = 0;

        while(end<nums.length && zeros<k){
            if(nums[end] == 0){
                zeros++;
            }else{
                ones++;
            }
            end++;
            maxSoFar = Math.max(maxSoFar,ones+zeros);
        }
        while(end < nums.length){
            if(nums[end] == 0){
                zeros++;
            }else{
                ones++;
            }
            while(start<=end && zeros>k){
                if(nums[start] == 0){
                    zeros--;
                }else{
                    ones--;
                }
                start++;
                
            }
            end++;
            maxSoFar = Math.max(maxSoFar,ones+zeros);
        }
        return maxSoFar;
    }
}