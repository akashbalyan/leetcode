class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> arr [] = new ArrayList[numCourses];
        Arrays.fill(arr, null);
        for(int [] array:prerequisites){
            int course = array[0];
            int prerequisite = array[1];
            if(arr[course] == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisite);
                arr[course] = list;
            }else{
                ArrayList<Integer> list = arr[course];
                list.add(prerequisite);
                arr[course] = list;
            }
        }
        boolean ans = true;
        HashSet<Integer> completed = new HashSet<>();
        //iterate through every course
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                HashSet<Integer> visited = new HashSet<>();

                if( !DFS(i,arr,visited,completed)){
                    return false;
                }
            }
        }
        return ans;

    }

    private boolean DFS(int course,ArrayList<Integer> arr[], HashSet<Integer> visited,HashSet<Integer> completed){
        if(arr[course] == null){
            return true;
        }
        if(visited.contains(course)){
            return false;
        }
        if (completed.contains(course)) return true;

        visited.add(course);
        
        ArrayList<Integer> list = arr[course];
        for(int i:list){
            if(!DFS(i,arr,visited,completed)){
                return false;
            }
        }
        visited.remove(course);
        completed.add(course);
        return true;
    }
}