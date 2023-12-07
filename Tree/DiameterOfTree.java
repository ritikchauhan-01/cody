// Leetcode - https://leetcode.com/problems/diameter-of-binary-tree/

package Tree;
import java.util.*;


public class DiameterOfTree {

    public static int dfs(TreeNode root, int[] diameter){
        if(root==null) return 0;

        int left = dfs(root.left,diameter);
        int right = dfs(root.right,diameter);
        diameter[0] = Math.max(diameter[0],left+right);
        return 1+Math.max(left,right);
    }

    public  static int diameterOfTree(TreeNode root){
        int[] diameter = new int[1];
        dfs(root,diameter);
        return diameter[0];
    }

    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
      
        int maxWidth = diameterOfTree(root);
        System.out.println("The maximum width of the Binary Tree is "+maxWidth);
    
    }
    
}


class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}