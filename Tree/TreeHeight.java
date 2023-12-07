// Leetcode - https://leetcode.com/problems/maximum-depth-of-binary-tree/

package Tree;
public class TreeHeight {

    static int heightOfTree(TreeNode root){
        if(root==null) return 0;

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        if(left==-1|| right==-1) return  -1;
        if(Math.abs(left-right)>1) return -1;

        return 1+ Math.max(left,right);
    }

    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
      
        int height = heightOfTree(root);

        if(height==-1){
            System.out.println("Tree is unbalanced");
        }
        else System.out.println("Tree is Balanced");
    
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
