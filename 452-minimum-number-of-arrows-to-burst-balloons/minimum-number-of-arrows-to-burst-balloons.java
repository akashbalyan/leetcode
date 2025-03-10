class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(points));
        Collections.sort(list,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> ansList = new ArrayList<>();
        int current[] = list.get(0);

        for(int i=1;i<list.size();i++){
            int point[] = list.get(i);
            if(current[1]<point[0]){
                ansList.add(current);
                current = point;
            }else{
                current[0] = point[0];
                current[1] = Math.min(current[1],point[1]);
            }
        }
        ansList.add(current);

        return ansList.size();
    }
}