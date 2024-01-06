package DP.BoundedKnapsack;
import java.util.*;

public class codeOfKnapsack1 {

    public static int knapsack1(int wt[], int val[],int dp[][], int n,int m){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(wt[i-1]<=j)
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                
                else 
                    dp[i][j] = dp[i-1][j];
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[n][m];
    }
    

    public static void main(String[] args){
        int wt[] = {1,4,5,3};
        int val[] = {3,6,7,8};
        int n = wt.length;
        int W = 7;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        int ans = knapsack1(wt,val,dp,n,W);
        System.out.println("maximum profit "+ans);
    }
}
