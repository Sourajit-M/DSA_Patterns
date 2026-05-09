package Precomputations;

import java.util.Scanner;

public class RangeSumQuery2d{
  private int prefix[][];
  public RangeSumQuery2d(int[][] matrix) {
    if(matrix==null || matrix.length==0 || matrix[0].length==0) return;

    int m = matrix.length;
    int n = matrix[0].length;
    prefix = new int[m][n];

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        int top = (i>0)? prefix[i-1][j] : 0;
        int left = (j>0)? prefix[i][j-1] : 0;
        int topleft = (i>0 && j>0)? prefix[i-1][j-1] : 0;
        prefix[i][j] = matrix[i][j] + top + left - topleft;
      }   
    }
  }
    
  public int sumRegion(int row1, int col1, int row2, int col2) {
    int total = prefix[row2][col2];
    int top = (row1>0)? prefix[row1-1][col2] : 0;
    int left = (col1>0)? prefix[row2][col1-1] : 0;
    int topleft = (row1>0 && col1>0)? prefix[row1-1][col1-1] : 0;
    return total - top - left + topleft;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows: ");
    int row = sc.nextInt();
    System.out.println("Enter the number of cols: ");
    int col = sc.nextInt();

    int matrix[][] = new int[row][col];

    System.out.println("Enter the elements of the matrix: ");
    for(int i=0; i<row; i++){
      for(int j=0; j<col; j++){
        matrix[i][j] = sc.nextInt();
      }
    }

    RangeSumQuery2d obj = new RangeSumQuery2d(matrix);
    System.out.println(obj.sumRegion(2, 1, 4, 3));

    sc.close();
  }
}