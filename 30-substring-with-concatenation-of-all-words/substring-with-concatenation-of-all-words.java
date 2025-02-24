class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n1=words[0].length();
        int n2=s.length();

        Map<String,Integer> map1=new HashMap<>();
        for(String ch:words){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<n1;i++){
            int left=i,j=i,c=0;
            Map<String,Integer> map2=new HashMap<>();
            while(j+n1<=n2){
                String word1=s.substring(j,j+n1);
                j+=n1;
                if(map1.containsKey(word1)) {
                    map2.put(word1,map2.getOrDefault(word1,0)+1);
                    c++;
                    
                    while(map2.get(word1)>map1.get(word1)) {
                        String word2=s.substring(left,left+n1);
                        map2.put(word2,map2.get(word2)-1);
                        left+=n1;
                        c--;
                    }
                    
                   if (c==words.length) ans.add(left);
                }
                   else{
                      map2.clear();
                      c=0;
                      left=j;
                }
            }
        }
    
        return ans;
        // ArrayList<Integer> ansList = new ArrayList<>();

        // Map<String,Integer> map1 = new HashMap<String,Integer>();
        // Map<String,Integer> map2 = new HashMap<String,Integer>();
        // for(String word:words){
        //     map1.put(word,map1.getOrDefault(word,0)+1);
        // }

        // int index = 0;
        // int lengthOfWord = words[0].length();
        // int stringLength = s.length();
        // int lengthOfAllWords = words.length;
        
        // for(int i=0;i<lengthOfWord;i++){

        //     int left = i;
        //     int count = 0;
        //     int j = i;

        //     while(j+lengthOfWord<=stringLength){

        //         String substr = s.substring(j,j+lengthOfWord);
        //         j=j+lengthOfWord;

        //         if(map1.containsKey(substr)){

        //             map2.put(substr,map2.getOrDefault(substr,0)+1);
        //             count++;

        //             while(map2.get(substr)>map1.get(substr)){
        //                 String word = s.substring(left,left+lengthOfWord);
        //                 map2.put(word,map2.get(word)-1);
        //                 left=left+lengthOfWord;
        //                 count--;
        //             }

        //             if(count == lengthOfAllWords) ansList.add(left);
        //         }else{
        //             map2.clear();
        //             count=0;
        //             left=j;
        //         }
        //     }
        // }
        // return ansList;
    }
}