package Counting;
import java.util.ArrayList;
public class MajorityElementII {
  public static ArrayList<Integer> majorityElementII(int nums[]){
    int candidate1 = nums[0];
    int count1 = 0;
    int candidate2 = nums[0];
    int count2 = 0;
    int n = nums.length;

    for(int i=0; i<n; i++){
      if(candidate1 == nums[i]){
        count1++;
      }else if(candidate2 == nums[i]){
        count2++;
      }else if(count1 == 0){
        candidate1 = nums[i];
        count1 = 1;
      }else if(count2 == 0){
        candidate2 = nums[i];
        count2 = 1;
      }else{
        count1--;
        count2--;
    }
    }

    //verify the candidates
    count1 = 0; count2 = 0;
    for(int num : nums){
      if(candidate1 == num) count1++;
      else if(candidate2 == num) count2++;
    }

    ArrayList<Integer> ans = new ArrayList<>();
    if(count1 > n/3) ans.add(candidate1);
    if(count2 > n/3) ans.add(candidate2);

    return ans;
  }
  public static void main(String[] args) {
    int nums[] = {2, 3, 2};
    ArrayList<Integer> result = majorityElementII(nums);
    System.out.println(result);
  }
}
