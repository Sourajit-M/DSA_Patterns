package Precomputations;

import java.util.Scanner;

public class RangeSumQuery1d {
  private int prefix[];
    public RangeSumQuery1d(int[] nums) {
        int n = nums.length;
        prefix = new int[n];

        prefix[0] = nums[0];

        for(int i=1; i<n; i++){
            prefix[i]  = prefix[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return (left>0)? prefix[right] - prefix[left-1] : prefix[right];
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the n: ");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array: ");
    for(int i=0; i<n; i++){
      nums[i] = sc.nextInt();
    }

    RangeSumQuery1d obj = new RangeSumQuery1d(nums);
    System.out.println(obj.sumRange(2, 5));

    sc.close();
  }
}
