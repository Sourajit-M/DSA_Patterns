package dp;

import java.util.Arrays;

public class Knapsack_01 {
    static int[][] dp;
    public static int knapsack(int W, int val[], int wt[]){
        int n = val.length;
        dp = new int[n+1][W+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(W, val, wt, 0, n);
    }
    private static int solve(int W, int val[], int wt[], int i, int n){
        if(i == n)
            return 0;

        if(dp[i][W] != -1)
            return dp[i][W];

        if(wt[i] > W)
            return dp[i][W] = solve(W, val, wt, i+1, n);

        //if take the item
        int yes = val[i] + solve(W-wt[i], val, wt, i+1, n);
        //did not take the item
        int no = solve(W, val, wt, i+1, n);

        return dp[i][W] = Math.max(yes, no);
    }
    public static void main(String[] args) {
        int W = 5;
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 2, 3};

        System.out.println(knapsack(W, val, wt));
    }
}
