package two_pointers;

import java.util.Arrays;

public class DutchNationalFlag {
    static void sortColors(int arr[]){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int mid = 0;

        while(mid <= right){
            if(arr[mid] == 0){
                swap(arr, left, mid);
                mid++;
                left++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                swap(arr, right, mid);
                right--;
            }
        }
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
