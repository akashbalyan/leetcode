class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];

        //when array is empty
        if(nums.length == 0){
            ans[0]=ans[1]=-1;
            return ans;
        }

        ans[0] = firstPosition(nums,target);
        ans[1] = lastPosition(nums,target);
        //return ans array
        return ans;
    }
    private int firstPosition(int [] nums, int target){
        //binary search
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        int first = -1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(target > nums[mid]){
                start = mid+1;
            }else if(target< nums[mid]){
                end = mid-1;
                
            }else{
                first = mid;
                end = mid -1;
            }
            
        }
        return first;
    }
    private int lastPosition(int [] nums, int target){
        //binary search
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        int last = -1;
        while(start<=end){
            mid = start + (end-start)/2;
            if(target > nums[mid]){
                start = mid+1;
            }else if(target< nums[mid]){
                end = mid-1;
                
            }else{
                last = mid;
                start = mid +1;
            }
            
        }
        return last;
    }
}