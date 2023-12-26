package Trie;

public class Implementation {

    static final int ALPHAET_SIZE = 26;

    static class TrieNode{
        TrieNode[] children = new TrieNode[ALPHAET_SIZE];

        // isEndOfWord is true is the node represent the end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord =false;
            for(int i=0;i<ALPHAET_SIZE;i++){
                children[i] = null;
            }
        }
    }
    static TrieNode root;

    static void insert(String key){
        TrieNode pCrawl = root;

        for(int  i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(pCrawl.children[i]==null)
                pCrawl.children[i] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark the last Node as leaf
        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key){
        TrieNode pCrawl = root;

        for(int  i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(pCrawl.children[i]==null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        // mark the last Node as leaf
        return (pCrawl.isEndOfWord);
    }

    public static void main(String args[]){
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        for(int i=0;i<keys.length;i++){
            insert(keys[i]);
        }

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }
    
}
