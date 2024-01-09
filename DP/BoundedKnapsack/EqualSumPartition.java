package DP.BoundedKnapsack;

public class EqualSumPartition {
    
    public static boolean helper(int[] nums, int s){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][s+1];

        for (int j = 1; j <= s; j++) {
            dp[0][j] = false;
        }
    
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){
                if(nums[i-1]<=j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][s];
    }

    public static boolean canPartition(int[] nums) {
        int sum=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        if(sum%2!=0)
            return false;
        else
            return helper(nums,sum/2);
    }   


    public static void main(String[] args){
        int[] arr = {2,3,5,8};
        System.out.println(canPartition(arr));
    }
}
