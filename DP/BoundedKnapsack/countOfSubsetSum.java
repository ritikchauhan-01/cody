package DP.BoundedKnapsack;

public class countOfSubsetSum {
    

    public static int countSubsetSum(int[] nums,int sum){
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];

        for(int i=0;i<sum+1;i++)
            dp[0][i] = 0;
        
        for(int i=0;i<n+1;i++)
            dp[i][0] = 1;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args){
        int[] arr = {2,3,5,6,8};
        int sum = 8;
        System.out.println(countSubsetSum(arr,sum));
    }
}
