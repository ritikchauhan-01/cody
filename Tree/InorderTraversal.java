// Leetcode 

package Tree;
import java.util.*;

class InorderTraversal {
    private List<Integer> ans = new ArrayList<>();
    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
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
 
