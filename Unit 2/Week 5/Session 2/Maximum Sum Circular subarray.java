public class Solution {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currentMax = 0;
        int maxSubarraySum = nums[0];
        
        int currentMin = 0;
        int minSubarraySum = nums[0];

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's for Maximum Subarray
            currentMax = Math.max(num, currentMax + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentMax);

            // Inverted Kadane's for Minimum Subarray
            currentMin = Math.min(num, currentMin + num);
            minSubarraySum = Math.min(minSubarraySum, currentMin);
        }

        // If all elements are negative, return the maximum single element
        if (maxSubarraySum < 0) {
            return maxSubarraySum;
        }

        // Return the maximum of non-wrapping sum vs. wrapping sum
        return Math.max(maxSubarraySum, totalSum - minSubarraySum);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3, -2};
        System.out.println(maxSubarraySumCircular(nums1)); // Output: 3

        int[] nums2 = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums2)); // Output: 10

        int[] nums3 = {-3, -2, -3};
        System.out.println(maxSubarraySumCircular(nums3)); // Output: -2
    }
}
