package Sliding_Window;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int freq[] = new int[2];
        int maxones = Integer.MIN_VALUE;
        int low = 0;

        for(int high=0; high<nums.length; high++){
            freq[nums[high]]++;
            int len = high - low + 1;
            int zeroes = len - freq[1];

            while(zeroes > k){
                freq[nums[low]]--;
                low++;
                len = high - low + 1;
                zeroes = len - freq[1];
            }

            len = high-low+1;
            maxones = Math.max(maxones, len);
        }

        return maxones==Integer.MIN_VALUE? 0 : maxones;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
}
