package Tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreePrePostOrder {

    public static TreeNode helper(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(postStart>postEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;

        root.left = helper(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inRoot-1, inMap);
        root.right = helper(postorder, postStart+numsLeft, postEnd-1, inorder, inRoot+1, inEnd, inMap);

        return root;
    }


    public static TreeNode buildTree(int[] postorder, int [] inorder){
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inMap);
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