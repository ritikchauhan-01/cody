package DP.LCS;
import java.util.*;

// Recursive soln with memoization

public class LongestCommonSubsequence {

    public static int helper(String s1, String s2, int n, int m, int[][] dp){
        if(n==0 || m==0)
            return 0;

        if(dp[n][m]!=-1)
            return dp[n][m];
        
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return dp[n][m] = 1+helper(s1,s2,n-1,m-1,dp);

        return dp[n][m] = Math.max(helper(s1,s2,n-1,m,dp),helper(s1,s2,n,m-1,dp));

    }


    public static int LCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }
        return helper(s1,s2,n,m,dp);
    }

    public static void main(String[] args){
        String s1 = "abcdef";
        String s2 = "abcdfg";
        int n = s1.length();
        int m = s2.length();

        int ans = LCS(s1,s2);
        System.out.println("Length of longest common subsequce "+ ans);

    }
}
