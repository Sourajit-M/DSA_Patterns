package Recursion;

public class RmSpecificCharFromString {
    public static String rmCharFromString(String str, int i, char ch){
        if(i == str.length()){
            return "";
        }

        if(str.charAt(i) == ch){
            return rmCharFromString(str, i+1, ch);
        }
        return str.charAt(i) + rmCharFromString(str, i+1, ch);
    }

    public static boolean isSorted(int arr[], int i){
        if(i == arr.length){
            return true;
        }

        if(arr[i] <= arr[i-1]){
            return false;
        }

        return isSorted(arr, i+1);
    }
    public static void main(String[] args) {
        String str = "apple";
        char ch = 'p';

        System.out.println(rmCharFromString(str, 0, ch));

        int[] arr = {1, 2, 3, 4, 6, 5};
        System.out.println(isSorted(arr, 1));
    }
}
