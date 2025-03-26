class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {  // ✅ Both adjacent spaces must be empty
                    flowerbed[i] = 1;  // ✅ Plant a flower
                    count++;
                    i += 2;  // ✅ Skip the next position (prevent adjacent planting)
                } else {
                    i++;  // ✅ Move forward
                }
            } else {
                i += 1;  // ✅ Move forward (not `i += 2`)
            }

            if (count >= n) {  // ✅ Early exit optimization
                return true;
            }
        }
        
        return count >= n;
    }
}