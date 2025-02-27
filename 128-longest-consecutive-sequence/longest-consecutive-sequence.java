class Solution {
    public int longestConsecutive(int[] nums) {

     HashSet<Integer> set = new HashSet<>();
     for(int n:nums){
        set.add(n);
     }   

        int longestSoFar =0;
     for(int n:set){

        if(!set.contains(n-1)){

            int length = 1;
            while(set.contains(n+length)){
                length++;
            }
            if(length >longestSoFar) longestSoFar = length;
        }
     }
     return longestSoFar;
    }
}