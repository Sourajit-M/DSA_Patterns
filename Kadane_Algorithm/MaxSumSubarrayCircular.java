package Kadane_Algorithm;

public class MaxSumSubarrayCircular {
    public static int maxSubarraySumCircular(int[] nums){
        int total = nums[0];
        int currMin = nums[0], bestMin = nums[0];
        int currMax = nums[0], bestMax = nums[0];

        for(int i=1; i<nums.length; i++){
            total += nums[i];

            currMin = Math.min(nums[i], currMin+nums[i]);
            bestMin = Math.min(currMin, bestMin);

            currMax = Math.max(nums[i], currMax+nums[i]);
            bestMax = Math.max(currMax, bestMax);
        }

        if (bestMax < nums[0])
            return bestMax;

        return Math.max(bestMax, total - bestMin);
    }
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
