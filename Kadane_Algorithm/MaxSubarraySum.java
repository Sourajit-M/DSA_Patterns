package Kadane_Algorithm;

public class MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int best = nums[0];

        for(int i=1; i<nums.length; i++){
            int v1 = nums[i]; //start from this num
            int v2 = best + nums[i]; // add to prev best
            best = Math.max(v1, v2);
            ans = Math.max(ans, best);
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
