// link - https://leetcode.com/problems/symmetric-tree

package Tree;

public class SymmetricTree {

    public static boolean helper(TreeNode p ,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p.data!=q.data) return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
    
    public static boolean isSymmetric(TreeNode root){
        if(root.left==null && root.right==null){
            return true;
        }

        return helper(root.left, root.right);
    }

    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(2);
        root . left . left = new TreeNode(3);
        root . left . right = new TreeNode(4);
        root . right = new TreeNode(2);
        root . right . left = new TreeNode(4);
        root . right . right = new TreeNode(3);
      
        boolean res;
        res = isSymmetric(root);
      
        if (res)
          System.out.println("The tree is symmetrical");
        else System.out.println("The tree is NOT symmetrical");
    }
}


class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}