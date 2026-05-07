import java.util.ArrayList;
import java.util.Scanner;

/**
  1
  1 1
  1 2 1
  1 3 3 1
  1 4 6 4 1
 */

public class PascalTriangle {
  public static ArrayList<ArrayList<Integer>> generate(int n){
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    if(n == 0) return result;

    ArrayList<Integer> firstRow = new ArrayList<>();
    firstRow.add(1);
    result.add(firstRow);

    if(n == 1) return result;

    for(int i=1; i<n; i++){
      ArrayList<Integer> prevRow = result.get(i-1);
      ArrayList<Integer> row = new ArrayList<>();
      
      //first element is 1
      row.add(1);

      for(int j=0; j<i-1; j++){
        row.add(prevRow.get(j) + prevRow.get(j+1));
      }

      //last element is 1
      row.add(1);

      result.add(row);
    }

    return result;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows: ");
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> arr = generate(n);
    for(int i=0; i<n; i++){
      for(int j=0; j<arr.get(i).size(); j++){
        System.out.print(arr.get(i).get(j)+ " ");
      }
      System.out.println();
    }
    sc.close();
  }
}