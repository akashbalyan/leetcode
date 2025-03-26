class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && !isVowel(arr[left])) left++;
            while (left < right && !isVowel(arr[right])) right--;

            // Swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    //     StringBuilder vowels = new StringBuilder("");
    //     for(char chr:s.toCharArray()){
    //         if(isVowel(chr)){
    //             vowels.append(chr);
    //         }
            
    //     }
    // StringBuilder res = new StringBuilder("");
    // int j = 0;
    //     for(int i=s.length()-1;  i>=0;i--){
    //             if(isVowel(s.charAt(i))){
    //                 res.append(vowels.charAt(j));
    //                 j++;
    //             }else{
    //                 res.append(s.charAt(i));
    //             }
    //     }
    // return res.reverse().toString();
        
    // }

    // private boolean isVowel(char chr){
    //     char c = chr;
    //         if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
    //             c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
    //                 return true;
    //                }
    //                return false;

    // }
}