public class Solution {
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either continue the existing subarray or start a new one from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Keep track of the overall maximum sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // Output: 6

        int[] nums2 = {1};
        System.out.println(maxSubArray(nums2)); // Output: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums3)); // Output: 23
    }
}
