class Solution {
    public boolean wordPattern(String pattern, String s) {
        String stringArray[] = s.split(" ");
        char charArray[] = pattern.toCharArray();
        HashMap<String , Character> map1 = new HashMap<>();
        HashMap<Character,String > map2 = new HashMap<>();

            if(stringArray.length != charArray.length){
                return false;
            }
        for(int i=0;i<stringArray.length;i++){

            if(!map1.containsKey(stringArray[i]) && !map2.containsKey(charArray[i])){
                    map1.put(stringArray[i],charArray[i]);
                    map2.put(charArray[i],stringArray[i]);
            }else if(map1.containsKey(stringArray[i]) && map1.get(stringArray[i]) != charArray[i]){
                return false;
            }else if(!map1.containsKey(stringArray[i]) && map2.containsKey(charArray[i]) ){
                return false;
            }else{

            }
        }
        return true;
        
    }
}