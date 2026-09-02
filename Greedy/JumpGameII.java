package Greedy;

public class JumpGameII {
    public static int jump(int[] nums) {
        int reach = 0;
        int curr_end = 0;
        int jumps = 0;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            reach = Math.max(reach, i+nums[i]);

            if(i == curr_end){
                curr_end = reach;
                jumps++;
            }
        }

        return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
