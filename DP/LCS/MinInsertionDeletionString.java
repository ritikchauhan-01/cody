package DP.LCS;

public class MinInsertionDeletionString {

    public static void minInsetionDeletionToConvert(String s1, String s2){
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

        // min Deletion => s1.length-LCS(dp[n][m])
        int deletion = n-dp[n][m];
        int insertion = m-dp[n][m];

        System.out.println("Min deletion: " + deletion);
        System.out.println("Min Insetion: " + insertion);

    }

    public static void main(String[] args){
        String s1 = "abcdef";
        String s2 = "abdfg";
        minInsetionDeletionToConvert(s1,s2);
    }
}
