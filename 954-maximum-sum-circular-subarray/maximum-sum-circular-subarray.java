class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int totalSum = 0;
        int maxSoFar = nums[0], minSoFar = nums[0];
        int currentMax = 0, currentMin = 0;

        for (int i : nums) {
            totalSum += i;

            // Kadane’s Algorithm for Maximum Subarray Sum
            currentMax = Math.max(currentMax + i, i);
            maxSoFar = Math.max(maxSoFar, currentMax);

            // Kadane’s Algorithm for Minimum Subarray Sum
            currentMin = Math.min(currentMin + i, i);
            minSoFar = Math.min(minSoFar, currentMin);
        }

        // If all numbers are negative, maxSoFar is the correct answer
        if (maxSoFar < 0) {
            return maxSoFar;
        }

        // Return the maximum of normal max subarray sum or circular subarray sum
        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}
