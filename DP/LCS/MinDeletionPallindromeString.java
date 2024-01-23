// Minimum no.of deletion is a string to make it a pallindrome

package DP.LCS;

public class MinDeletionPallindromeString {

    // min Deletion = length of string - LCS(s1,reverse(S1))
    public static int minDeletionPallindromeString(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++)
            dp[i][0] = 0;

        for(int i=0;i<m+1;i++)
            dp[0][i] = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return n-dp[n][m];    
    }

    public static void main(String[] args){
        String s1 = "abcba";
        String s2 = "";
        for(int i=0;i<s1.length();i++)
            s2 = s1.charAt(i) + s2;
        int len = minDeletionPallindromeString(s1,s2);
        System.out.println("length of longest pallindromic subsequence: "+ len);
    }
}
