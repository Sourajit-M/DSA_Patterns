package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n < 4) return res;

        Arrays.sort(nums);

        for(int i=0; i<n-3; i++){
            //skip duplicates
            if(i>0 && nums[i]==nums[i-1])
                continue;

            for(int j=i+1; j<n-2; j++){
                //skip duplicates
                if(j>i+1 && nums[j-1] == nums[j])
                    continue;

                int left = j+1;
                int right = n-1;

                while(left < right){
                    long sum = (long)nums[i] + nums[j]
                            + nums[left] + nums[right];
                    
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        left++;
                        right--;

                        //skip duplicates
                        while (left<right && nums[left]==nums[left-1]) {
                        left++;
                        }

                        //skip duplicates
                        while (left<right && nums[right]==nums[right+1]) {
                            right--;
                        }
                    }
                    else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
