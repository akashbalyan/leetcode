class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        Collections.sort(list,(a,b)->a[0]-b[0]);

        List<int[] > result = new ArrayList<>();

        int [] current = list.get(0);

        for(int i=1;i<list.size();i++){
            int interval[] = list.get(i);

            if(current[1]<interval[0]){
                result.add(current);
                current = interval;
            }else{
                current[1] = Math.max(current[1],interval[1]);
            }

        }
        result.add(current);


        return result.toArray(new int[result.size()][]);
    }
}