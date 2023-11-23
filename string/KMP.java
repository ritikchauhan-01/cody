// leetcode - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {
    static int[] computeArray(String s){
        int[] arr = new int[s.length()];
        int index=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(index)){
                arr[i] = index+1;
                i++;
                index++;
            }
            else{
                if(index!=0){
                    index = arr[index-1];
                }
                else{
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return arr;
    }

    static boolean KMP(String haystack, String needle) {
        int[] dp = computeArray(needle);
        int i=0;
        int j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j!=0){
                    j = dp[j-1];
                }
                else{
                    i++;
                }
            }
            if(j==needle.length()){
                return true;
            }
        }
    return false;
    }
    public static void main(String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        boolean result = KMP(str ,subString);
        System.out.print(result);
}