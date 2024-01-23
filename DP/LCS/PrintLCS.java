package DP.LCS;

public class PrintLCS {

    public static String printLCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
            dp[i][0] = 0;
        
        for(int j=0;j<m+1;j++)
            dp[0][j] = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

            }
        }

        int i=n,j=m;
        String s = "";
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                s = s1.charAt(i-1) + s;
                i--;
                j--;
            }
            else{
                if(dp[i][j-1]>dp[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        return s;
    }


    public static void main(String[] args){
        String s1 = "abcdef";
        String s2 = "abcdfg";
        String s = printLCS(s1,s2);
        System.out.println("Length of longest common subsequce "+s);
    }
    
}
