package sliding_window;

public class MinsizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minlength = Integer.MAX_VALUE;

        int low = 0, high = 0;
        int sum = 0;

        while(high < n){
            sum += nums[high];

            while(sum >= target){
                int len = high-low+1;
                minlength = Math.min(len, minlength);
                sum -= nums[low];
                low++;
            }

            high++;
        }

        return minlength==Integer.MAX_VALUE? 0 : minlength;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
        System.out.println(Integer.toString(Integer.MAX_VALUE).length());
    }
}
