package two_pointers;

import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1

public class Segregate0and1{
    static void segregate0and1(int[] arr) {
        int left = 0, right = arr.length-1;
        int i = 0;
        while(i <= right){
            if(arr[i] == 0){
                swap(arr, i, left);
                left++;
                i++;
            }else{
                swap(arr, i, right);
                right--;
            }
        }
    }
    static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        segregate0and1(arr);
        System.out.println(arr.toString());

        sc.close();
    }
}