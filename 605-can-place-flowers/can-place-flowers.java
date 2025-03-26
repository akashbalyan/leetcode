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
                if(condition1 == condition2){
                    count++;
                    i=i+2;
                }else{
                    i++;
                }

                
            }else{
                i=i+2;
            }
        }
     System.out.println("count"+count);
        return count >= n;
    }
}