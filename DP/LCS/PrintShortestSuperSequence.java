package DP.LCS;

public class PrintShortestSuperSequence {
    // It is similar to the PrintLCS solution

    public static String shortestSuperSequence(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
            dp[i][0] = 0;
        for(int i=0;i<m+1;i++)
            dp[0][i] =0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        int i=n,j=m;
        String ans="";
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans = s1.charAt(i-1) + ans;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans = s1.charAt(i-1) + ans;
                i--;
            }
            else{
                ans = s2.charAt(j-1) + ans;
                j--;
            }
        }
        while(i>0){
            ans = s1.charAt(i-1) + ans;
            i--;
        }
        while(j>0){
            ans = s2.charAt(j-1) + ans;
            j--;
        }

        return ans;
    }

    public static void main(String[] args){
        String s1 = "abcdef";
        String s2 = "abdfg";
        String ans = shortestSuperSequence(s1,s2);
        System.out.println("length of shortest super sequence: " + ans);
    }
}
