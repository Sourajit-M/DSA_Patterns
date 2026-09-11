package binary_search;

public class FindPeakElement {
    public static  int findPeakElement(int[] nums){
        int n = nums.length;

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mid > 0 &&  mid < n-1 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            else if(mid < n-1 && nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
