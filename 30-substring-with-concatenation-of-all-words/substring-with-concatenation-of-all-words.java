class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        ArrayList<Integer> ansList = new ArrayList<>();

        Map<String,Integer> map1 = new HashMap<String,Integer>();
        
        for(String word:words){
            map1.put(word,map1.getOrDefault(word,0)+1);
        }

        int index = 0;
        int lengthOfWord = words[0].length();
        int stringLength = s.length();
        int lengthOfAllWords = words.length;
        
        for(int i=0;i<lengthOfWord;i++){

            int left = i;
            int count = 0;
            int j = i;
            Map<String,Integer> map2 = new HashMap<String,Integer>();
            
            while(j+lengthOfWord<=stringLength){

                String substr = s.substring(j,j+lengthOfWord);
                j=j+lengthOfWord;

                if(map1.containsKey(substr)){

                    map2.put(substr,map2.getOrDefault(substr,0)+1);
                    count++;

                    while(map2.get(substr)>map1.get(substr)){
                        String word = s.substring(left,left+lengthOfWord);
                        map2.put(word,map2.get(word)-1);
                        left=left+lengthOfWord;
                        count--;
                    }

                    if(count == lengthOfAllWords) ansList.add(left);
                }else{
                    map2.clear();
                    count=0;
                    left=j;
                }
            }
        }
        return ansList;
    }
}