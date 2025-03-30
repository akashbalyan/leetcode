class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int arr [][] = new int[len][2];

        for(int i=0;i<len;i++){
            arr[i][0] = nums2[i];
            arr[i][1] = nums1[i];
        }

        Arrays.sort(arr,(a,b)->b[0]-a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumNums1 = 0, maxScore =0;

        for(int i=0;i<len;i++){
            int minNums2 = arr[i][0];  // Current nums2 value
            int num1 = arr[i][1];  // Corresponding nums1 value
            
            // Add nums1[i] to heap and update sum
            minHeap.add(num1);
            sumNums1 += num1;

            // If heap size exceeds k, remove the smallest nums1 element
            if (minHeap.size() > k) {
                sumNums1 -= minHeap.poll();
            }

            // When exactly k elements are chosen, update maxScore
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sumNums1 * minNums2);
            }
        }
        return maxScore;
    }
}