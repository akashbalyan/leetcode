class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i=0;
        while(i<flowerbed.length){
            if(flowerbed[i] == 0){
                boolean condition1 = false;
                boolean condition2 = false;
                if(i-1>=0){
                        if(flowerbed[i-1] == 0){
                            condition1 = true;
                        }
                }else{
                    condition1 =true;
                }

                if(i+1 <flowerbed.length){
                        if(flowerbed[i+1] == 0){
                            condition2 = true;
                        }
                }else{
                    condition2 =true;
                }
                if(condition1 && condition2){
                    count++;
                    i=i+2;
                }else{
                    i++;
                }

                
            }else{
                i=i+2;
            }
            if(count>=n){
                return true;
            }
        }
     System.out.println("count"+count);
        return count >= n;
    
        // int count = 0;
        // int i = 0;
        
        // while (i < flowerbed.length) {
        //     if (flowerbed[i] == 0) {
        //         boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
        //         boolean rightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                
        //         if (leftEmpty && rightEmpty) {  // ✅ Both adjacent spaces must be empty
        //             flowerbed[i] = 1;  // ✅ Plant a flower
        //             count++;
        //             i += 2;  // ✅ Skip the next position (prevent adjacent planting)
        //         } else {
        //             i++;  // ✅ Move forward
        //         }
        //     } else {
        //         i += 1;  // ✅ Move forward (not `i += 2`)
        //     }

        //     if (count >= n) {  // ✅ Early exit optimization
        //         return true;
        //     }
        // }
        
        // return count >= n;
    }
}