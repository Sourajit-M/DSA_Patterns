package sliding_window;

public class MaxSumSubarrayEqualToK {
    public static int maxSubarraySum(int[] arr, int k) {
        int ans = 0;
        int sum = 0;
        int left = 0;
        for(int right=0; right<arr.length; right++){
            if(right < k){
                sum += arr[right];
                ans = sum;
            }else{
                sum -= arr[left++];
                sum += arr[right];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400};
        int k = 2;
        System.out.println(maxSubarraySum(arr, k));
    }
}
