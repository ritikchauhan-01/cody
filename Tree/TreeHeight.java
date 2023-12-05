package Tree;

public class TreeHeight {

    static int heightOfTree(TreeNode root){
        if(root==null) return 0;

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

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
      
        int maxWidth = heightOfTree(root);
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
