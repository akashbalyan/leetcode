class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean [][] graph = new boolean[numCourses][numCourses];
        List<Boolean> resultList = new ArrayList<>();  


        for(int[] pre: prerequisites){
            graph[pre[0]][pre[1]] = true;

        }

        for(int x = 0;x<numCourses;x++){
                for(int i = 0;i< numCourses;i++){
                    for(int j=0;j<numCourses;j++){

                        if(graph[i][x] == true &&
                         graph[x][j] == true){
                            graph[i][j] = true;
                        }
                    }
                }
        }

        for(int [] query : queries ){
            resultList.add(graph[query[0]][query[1]]);
        }
        
        return resultList;

        
    }
}