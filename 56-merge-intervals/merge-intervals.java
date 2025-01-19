class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < intervals[i][0]){
                merged.add(intervals[i]);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size() - 1)[1], intervals[i][1]);
            }
        }

        
        return merged.toArray(new int[merged.size()][]);
    }
    private class Pair{
        int a;
        int b;

        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
}