class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i:candies){
            max = Math.max(i,max);
        }
        List<Boolean> ansList = new ArrayList<>();
        for(int i:candies){
            if(i + extraCandies >=max){
                ansList.add(true);
            }else{
                ansList.add(false);
            }
        }
        return ansList;
    }
}