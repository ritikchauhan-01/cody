package DP;
import java.util.*;

public class LIS {
    public static int recursion(int[] nums,int[][] memo, int curr, int prev){
        if(curr==nums.length) return 0;

        if(memo[curr][prev+1]!=0)
            return memo[curr][prev+1];

        int add=0,not_add=0;

        if(prev ==-1 || nums[curr]>nums[prev])
            add = 1+recursion(nums,memo,curr+1,curr);

        not_add = 0+recursion(nums,memo,curr+1,prev);
        
        return memo[curr][prev+1] = Math.max(add,not_add);

    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        return recursion(nums,dp,0,-1);
    }

    


    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + lengthOfLIS(arr, n));
    }
}

// optimized soln
    // public static int  lengthOfLISOptimized(int[] nums){
    //     if(nums.length==0) return 0;
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp,1);

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(nums[i]>nums[j]){
    //                 dp[i] = Math.max(dp[i],dp[j]+1);
    //             }
    //         }
    //     }

    //     int maxAns = 1;
    //     for(int i : dp) maxAns = Math.max(maxAns, i);

    //     return maxAns;
    // }