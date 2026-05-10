package Maths;

public class Pow_x_n{
  public static double myPow(double x, int n){
    long N = n;

    if(N < 0){
      x = 1/x;
      N = -N;
    }

    return power(x, N);
  }
  public static double power(double x, long n){
    if(n == 0) return 1.0;
    double half = power(x, n / 2);

    if(n%2 == 0){
      return half*half;
    }else{
      return half*half*x;
    }
  }
  public static void main(String[] args) {
    double x = 2.0;
    int n = 2;

    System.out.println(myPow(x, n));
  }
}