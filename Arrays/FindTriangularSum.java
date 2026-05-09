// https://leetcode.com/problems/find-triangular-sum-of-an-array/description/

import java.util.Scanner;

public class FindTriangularSum {

  public static int triangularSum(int[] nums) {
    int n = nums.length;
    for(int i=0; i<n-1; i++){
      for(int j=0; j<n-1-i; j++){
        nums[j] = (nums[j] + nums[j+1]) % 10;
      }
    }
    return nums[0];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements of array: ");
    int n = sc.nextInt();

    int arr[] = new int[n];
    System.out.println("Enter the elements of the array: \n");
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }

    int result = triangularSum(arr);
    System.out.println("Result = "+ result);
    sc.close();
  }
}
