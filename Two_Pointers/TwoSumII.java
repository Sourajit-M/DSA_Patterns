package two_pointers;

import java.util.Scanner;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target)
                return new int[]{left, right};
            else if(sum < target)
                left++;
            else 
                right--;
        }

        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(twoSum(arr, target).toString());

        sc.close();
    }
}
