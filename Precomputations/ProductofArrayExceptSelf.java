package Precomputations;

public class ProductofArrayExceptSelf {
  public static int[] product_of_array_except_self(int nums[]){
    int n = nums.length;
    int ans[] = new int[n];

    int prefix_product = 1, suffix_product = 1;

    for(int i=0; i<n; i++){
      ans[i] = prefix_product;
      prefix_product *= nums[i];
    }

    for(int i=n-1; i>=0; i--){
      ans[i] *= suffix_product;
      suffix_product *= nums[i];
    }

    return ans;
  }

  public static int[] product_of_array_except_self_v2(int nums[]){
    int n = nums.length;
    int prefix[] = new int[n];
    int suffix[] = new int[n];

    int prod = 1;

    for(int i=0; i<n; i++){
      prefix[i] = prod;
      prod *= nums[i];
    }

    prod = 1;

    for(int i=n-1; i>=0; i--){
      suffix[i] = prod;
      prod *= nums[i];

      prefix[i] = prefix[i] * suffix[i];
    }

    return prefix;
  }

  public static void display(int nums[]){
    for(int i=0; i<nums.length; i++)
      System.out.print(nums[i] +" ");
    System.out.println();
  }
  public static void main(String[] args) {
    int nums[] = {1,2,3,4};
    int ans1[] = product_of_array_except_self(nums);
    System.out.println("V1: ");
    display(ans1);
    int ans2[] = product_of_array_except_self_v2(nums);
    System.out.println("V2: ");
    display(ans2);
  }
}
