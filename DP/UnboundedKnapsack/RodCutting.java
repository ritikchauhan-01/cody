package DP.UnboundedKnapsack;

import java.util.Arrays;

public class RodCutting {

    public static int rodCutting(int[] length, int[] price, int W){
        int n = price.length;

        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<n+1;i++)
            dp[0][i] = 0;
        
        for(int i=0;i<n+1;i++)
            dp[i][0] = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(length[i-1]<=j)
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                
                else 
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][n];
    }
    
    public static void main(String[] args){
            int val[] = {1,2,3,4,5,6,7,8};
            int W = 8;

            int[] length = new int[val.length];
            for(int i=1;i<=val.length;i++){
                length[i-1] = i;
            }
            
            // int dp[][] = new int[val.length+1][W+1];
            // for(int i=0;i<n+1;i++){
            //     for(int j=0;j<W+1;j++){
            //         dp[i][j] = -1;
            //     }
            // }
            int ans = rodCutting(length,val,W);
            System.out.println("maximum profit "+ans);
        }

}
