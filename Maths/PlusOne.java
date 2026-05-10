package Maths;

public class PlusOne{
  public static int[] plusOne(int nums[]){
    int n = nums.length;

    for(int i=n-1; i>=0; i--){
      if(i == n-1){
        nums[i] += 1;
      }

      if(nums[i] > 9){
        nums[i] = 0;
        if(i > 0){
          nums[i-1] += 1;
        }
      }else{
        return nums;
      }
    }

    int ans[] = new int[n+1];
    ans[0] = 1;
    return ans;
  }
  public static void display(int nums[]){
    for(int i=0; i<nums.length; i++)
      System.out.print(nums[i] +" ");
    System.out.println();
  }
  public static void main(String[] args) {
    int digits[] = {4,3,2,1};
    int digits2[] = {9, 9, 9};

    display(plusOne(digits));
    display(plusOne(digits2));
  }
}