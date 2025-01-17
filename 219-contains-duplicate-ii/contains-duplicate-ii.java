class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }else{
                ArrayList<Integer> list = map.get(nums[i]);
                for(int j:list){
                    if(i-j <= k){
                        return true;
                    }
                }
                list.add(i);
                map.put(nums[i],list);
            }
        }
        return false;
    }
}