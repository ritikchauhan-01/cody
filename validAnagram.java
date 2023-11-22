// leetcode - https://leetcode.com/problems/group-anagrams/description/

import java.util.*;
public class validAnagram {
    // TC is O(nlogn) -> for sorting
    static boolean isAnagram1(String s, String t){
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar,tChar);
    }

    // TC O(n) Storing values in map
    static boolean isAnagram2(String s, String t){
        Map<Character, Integer> map = new HashMap<>();
        for( char x: s.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char x: t.toCharArray()){
            map.put(x,map.getOrDefault(x,0)-1);
        }

        for(int val: map.values()){
            if(val!=0){
                return false;
            }
        }
        return true;
    }

    // TC o(n) hashtable using array
    static boolean isAnagram3(String s, String t){
        int[] count = new int[26];
        for(char x: s.toCharArray()){
            count[x-'a']++;
        }

        for(char x: t.toCharArray()){
            count[x-'a']++;
        }
        
        for(int val: count){
            if(val!=0){
                return false;
            }
        }
        return true;
    }

    public static void main (String args[]){
        String s1 = "abcxabcdabcdabcy";
        String s2 = "abcdabcy";
        System.out.println(isAnagram1(s1,s2));
        System.out.println(isAnagram2(s1,s2));
        System.out.println(isAnagram3(s1,s2));
    }
}


