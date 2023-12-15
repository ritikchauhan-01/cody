// LeetCode - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/519925876/

package Tree;
import java.util.*;

public class BinaryTreenPreOrder {

    public static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot-inStart;

        root.left = helper(preorder, preStart+1,preEnd+numsLeft,inorder, inStart,inRoot-1,inMap);
        root.right= helper(preorder, preStart+numsLeft+1,preEnd, inorder, inRoot+1,inEnd,inMap);

        return root;


    }

    public static TreeNode buildTree(int[] preorder, int [] inorder){
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
    }
    
    public static void main(String args[]) {
        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        TreeNode root = buildTree(preorder, inorder);
    }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
    left = null;
    right = null;
  }
}