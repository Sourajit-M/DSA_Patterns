package kadanes_algo;

public class MaxSubarraySumWithOneDel {
    public static int maximumSum(int[] arr){
        int ans = 0;
        int del = 0;
        int no_del = arr[0];

        for(int i=1; i<arr.length; i++){
            int v1 = arr[i]; // only this num
            int v2 = no_del + arr[i]; // no skipped + this num
            int v3 = del + arr[i]; // previously skipped + this num
            int v4 = no_del; //skip this element

            no_del = Math.max(v1, v2);
            del = Math.max(v3, v4); 

            ans = Math.max(ans, Math.max(del, no_del));
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,-2,0,3};
        System.out.println(maximumSum(nums));
    }
}
