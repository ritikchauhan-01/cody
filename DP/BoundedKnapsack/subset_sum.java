package DP.BoundedKnapsack;
import java.util.*;

public class subset_sum {
    public static boolean subsetSum(int[] arr, boolean[][] dp, int n, int sum){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args){
        int[] arr = {2,3,7,8};
        int sum = 5;
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        }
        boolean result = subsetSum(arr,dp,n,sum);
        System.out.println(result);
    }
    
}
