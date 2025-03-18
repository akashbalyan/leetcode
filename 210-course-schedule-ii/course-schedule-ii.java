class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] arr = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = new ArrayList<>();
        }

        // Build the graph
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            arr[prereq].add(course);  // Correct representation: prereq → course
        }
        
        HashSet<Integer> completed = new HashSet<>();
        //iterate through every course
        ArrayList<Integer> finalAnsList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                HashSet<Integer> visited = new HashSet<>();
                ArrayList<Integer> ansList = new ArrayList<>();
                if( !DFS(i,arr,visited,completed,ansList)){

                    return new int[0];
                }else{
                   
                    finalAnsList.addAll(ansList);
                }
            }
        }

Collections.reverse(finalAnsList);
         int[] array = new int[finalAnsList.size()];
                    for (int j = 0; j < finalAnsList.size(); j++) {
                        array[j] = finalAnsList.get(j); // Manually copying values
                    }
        return array;

    }

    private boolean DFS(int course,ArrayList<Integer> arr[], HashSet<Integer> visited,HashSet<Integer> completed, ArrayList<Integer> ansList){
        
        if(visited.contains(course)){
            return false;
        }
        
        if (completed.contains(course)) return true;

        visited.add(course);
        
        ArrayList<Integer> list = arr[course];
        for(int i:list){
            if(!DFS(i,arr,visited,completed,ansList)){
                return false;
            }
        }
        visited.remove(course);
        completed.add(course);
        ansList.add(course);
    
        return true;
    }
}