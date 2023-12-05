// LeetCode - https://leetcode.com/problems/binary-tree-level-order-traversal/

package Tree;
import java.util.*;

public class levelOrderTraversal {

    static List<List<Integer>> levelOrderTraversalTree(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                subLevel.add(q.remove().val);
            }
            ans.add(subLevel);
        }
        return ans;
    }



    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
      
        List<List<Integer>> maxWidth = levelOrderTraversalTree(root);
        System.out.println("The maximum width of the Binary Tree is "+maxWidth);
    
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
}