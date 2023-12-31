// leetcode - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

import java.util.*;
public class MITM_pallindrome {
    static int backtrack(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int minInsertions(String s) {
        int n = s.length();
        String sReverse = new StringBuilder(s).reverse().toString();

        return n-backtrack(s,sReverse,n,n);
    }
}
