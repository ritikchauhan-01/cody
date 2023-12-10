package Tree;

public class LCA {
    
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(right==null) return left;
        if(left==null) return right;
        else return root;
    }

    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(6);
      
        TreeNode resultTreeNode = lowestCommonAncestor(root,p,q);
        System.out.println("The maximum width of the Binary Tree is "+resultTreeNode);
    
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