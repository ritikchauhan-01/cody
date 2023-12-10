package Tree;

public class CheckIdenticalTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    // main function write yourself
    
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