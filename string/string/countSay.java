package string;
// Leetcode : https://leetcode.com/problems/count-and-say/description/

import java.util.*;

class countSay1 {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        int k=1;
        String s="1";
        while(k!=n){
            int count=1;
            String say="";
            for(int i=0;i<s.length();i++){
                if(i!=(s.length()-1) && s.charAt(i)==s.charAt(i+1)){
                    count+=1;
                    continue;
                }
                else{
                    say += Integer.toString(count) + s.charAt(i);
                    count = 1;
                }
            }
            s=say;
            k+=1;
        }
        return s;
    }
}

// Time complexity: O(n+k)O(n+k)O(n+k) where k is the variable length of the strings formed.
class countSay2 {
    public String helper(String s){
        StringBuilder str = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==c){
                count++;
            }
            else{
                str.append(count);
                str.append(c);
                c=s.charAt(i);
                count = 1;
            }
        }
        str.append(count);
        str.append(c);
        return str.toString();
    }

    public String countAndSay(int n) {
        String ans = "1";
        for(int i=2;i<=n;i++){
            ans = helper(ans);
        }

        return ans;
    }
}