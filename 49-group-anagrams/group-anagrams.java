class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ansList;

        HashMap<String ,ArrayList<String>> map = new HashMap<>();
        for(String s:strs){
            int [] arr = new int[26];
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                arr[c-'a']++;
            }
            StringBuilder stb = new StringBuilder("");
            for(int i=0;i<26;i++){
                if(arr[i]!=0){
                    stb.append((char)('a'+i)).append(arr[i]);
                }
                
            }
            String stbString = stb.toString();
            if(map.containsKey(stbString)){
                ArrayList<String> aList = map.get(stbString);
                aList.add(s);
                map.put(stbString,aList);
            }else{
                ArrayList<String> aList = new ArrayList<>();
                aList.add(s);
                map.put(stbString,aList);
            }
        }

        ansList = new ArrayList(map.values());
        return ansList;
    }
}