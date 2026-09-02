package Patterns.Prefix_Sum;

// sum of elem i-1 == sum from i+1 to n -- return n

public class FindPivotIndex {
    public static int pivotIndex(int[] nums){
        int n = nums.length;
        int prefix[] = new int[n+1];

        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        for(int i=0; i<n; i++){
            if(prefix[i] == prefix[n] - prefix[i+1])
                return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
