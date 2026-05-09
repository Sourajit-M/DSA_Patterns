package Precomputations;

import java.util.Arrays;
import java.util.Scanner;

public class CountPrime {
  public static int count_prime(int n){
    if(n < 2) return 0;

    boolean isprime[] = new boolean[n];
    Arrays.fill(isprime, true);
    isprime[0] = isprime[1] = false;

    int count = 0;

    for(int i=2; i*i<=n; i++){
      if(!isprime[i]) continue;
      for(int j=i*i; j<n; j+=i){
        isprime[j] = false;
      }
    }

    for(int i=2; i<n; i++){
      if(isprime[i]){
        System.out.print(i+ " ");
        count++;
      }
      System.out.println();
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number: ");
    int n = sc.nextInt();
    int res = count_prime(n);
    System.out.println("Number of prime numbers < number= "+ res);
    sc.close();
  }
}
