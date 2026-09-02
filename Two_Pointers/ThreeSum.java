package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    static List<List<Integer>> threeSum(int nums[]){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    left++;
                    right--;

                    ans.add(list);
                    while (left<right && nums[left]==nums[left-1]) {
                        left++;
                    }
                    while (left<right && nums[right]==nums[right+1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    static int threeSumClosest(int nums[], int target){
        int min_diff = Integer.MAX_VALUE;
        int ans = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            //since no duplicates we dont check it
            int left = i+1, right=n-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if(min_diff > diff){
                    min_diff = diff;
                    ans = sum;
                }

                if(sum == target){
                    return sum;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[]  = {-1,2,1,-4};
        // System.out.println(threeSum(nums));
        System.out.println(threeSumClosest(nums, 1));
    }
}