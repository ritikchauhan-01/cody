// Leetcode -https://leetcode.com/problems/compare-version-numbers/

import java.util.*;

public class version {
    static int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        boolean versionLeft = true;

        while(versionLeft){
            int num1 = 0;
            int num2 = 0;
            while(i<version1.length() && version1.charAt(i)!='.'){
                num1 = num1*10 + version1.charAt(i)-'0';
                i++;
            }
            while(j<version2.length() && version2.charAt(j)!='.'){
                num2 = num2*10 + version2.charAt(j)-'0';
                j++;
            }

            if(num1>num2){
                return 1;
            }
            else if(num1<num2){
                return -1;
            }

            if(i>=version1.length() && j>=version2.length()){
                return 0;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main (String args[]){
        String s1 = "1.01";
        String s2 = "1.001";

        System.out.println(compareVersion(s1,s2));
    }

}
