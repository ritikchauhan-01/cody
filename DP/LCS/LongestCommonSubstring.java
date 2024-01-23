package DP.LCS;

import java.util.Arrays;

public class LongestCommonSubstring {

    // Length of longest common substring;
    public static int LCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
            dp[i][0] = 0;

        for(int j=0;j<m+1;j++)
            dp[0][j] = 0;

        
        int max=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
                max= Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    public static String LCSPrint(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
            dp[i][0] = 0;

        for(int j=0;j<m+1;j++)
            dp[0][j] = 0;

        
        int max=0;
        int endIndex = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(max<dp[i][j]){
                        max = dp[i][j];
                        endIndex = i;
                    }
                else
                    dp[i][j] = 0;
            }
        }
        return s1.substring(endIndex-max, max);
    }

    public static void main(String[] args){
        String s1 = "abcdef";
        String s2 = "abcdfg";
        int n = s1.length();
        int m = s2.length();

        int ans = LCS(s1,s2);
        String s = LCSPrint(s1, s2);
        System.out.println("Length of longest common substring : "+ ans);
        System.out.println("longest common substring : "+s);
    }
}
