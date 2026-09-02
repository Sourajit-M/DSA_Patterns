package DP;
public class Fibonacci {
    public static long fibo(int n, long[] dp) {
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 100;
        long dp[] = new long[n+1];
        dp[0] = 0; dp[1] = 1;

        long ans = fibo(n, dp);
        int len = Long.toString(ans).length();
        System.out.println(len);
    }
}
