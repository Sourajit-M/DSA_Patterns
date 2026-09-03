package Two_Pointers;

import java.util.Scanner;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class MinWindowSort {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        //find violation from left
        while(left<n-1 && nums[left] <= nums[left+1])
            left++;

        //already sorted array
        if(left == n-1)
            return 0;

        while(right>0 && nums[right] >= nums[right-1])
            right--;
        

        int max_seen = Integer.MIN_VALUE;
        int min_seen = Integer.MAX_VALUE;

        for(int i=left; i<=right; i++){
            max_seen = Math.max(nums[i], max_seen);
            min_seen = Math.min(nums[i], min_seen);
        }

        while(left>0 && nums[left-1] > min_seen)
            left--;
        
        while(right<n-1 && nums[right+1] < max_seen)
            right++;

        return right - left + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findUnsortedSubarray(arr));
        sc.close();
    }
}
