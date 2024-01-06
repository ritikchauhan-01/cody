// we will be given a wt[] array and val[] array , canpacity(kg) of bag which it can hold
// then we have to find the maximum profit we can get by filling bag

package DP.BoundedKnapsack;

import java.util.Arrays;

// To Meomoize the code uncommnet the code lines

public class codeOfKnapsack {

    public static int knapsack(int wt[], int val[], int W, int n){
        // Base condn
        if(n==0 || W==0)
            return 0;

        //memoization 
        // if (dp[n][W]!=-1)
        //     return dp[n][W];


        // Choice Diagaram
        if(wt[n-1]<=W)
            //return dp[n][W] = Math.max(val[n-1]+knapsack(wt, val, W-wt[n-1], n-1),knapsack(wt, val, W, n-1));
            return  Math.max(val[n-1]+knapsack(wt, val, W-wt[n-1], n-1),knapsack(wt, val, W, n-1));
        else if(wt[n-1]>W)
            //return dp[n][W] = knapsack(wt, val, W, n-1);
            return knapsack(wt, val, W, n-1);

        else return 0;
    }

    public static void main(String[] args){
        int wt[] = {1,4,5,3};
        int val[] = {3,6,7,8};
        int W = 7;
        int n = wt.length;
        // int dp[][] = new int[val.length+1][W+1];
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<W+1;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        int ans = knapsack(wt,val,W,n);
        System.out.println("maximum profit "+ans);
    }
}
