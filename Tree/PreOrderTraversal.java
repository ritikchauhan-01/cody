
package Tree;
import java.util.*;

public class PreOrderTraversal {
    private List<Integer> ans = new ArrayList<>();
    private void traverse(TreeNode root){
        if(root==null){
            return;
        }
        ans.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return ans;

        
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
