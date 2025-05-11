class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int len = result.length;
        //left product
        for(int i=0;i<len;i++){
            if(i == 0){
                result[i] =1;
            }else{
                result[i] = result[i-1] * nums[i-1];
            }
        }

        //right prf=duct
        int rightProduct = 1;
        for(int i=len-1;i>=0;i--){
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        //return result
        return result;
    }
}