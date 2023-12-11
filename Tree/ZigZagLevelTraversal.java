// Leetcode - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

package Tree;
import java.util.*;

public class ZigZagLevelTraversal {
    public static List<List<Integer>> ZigZagLevelOrderTraversal(TreeNode root){
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null){
            return answer;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                if(flag) level.addLast(temp.val);
                else level.addFirst(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                } 
                if(temp.right!=null){
                    q.add(temp.right);
                } 
            }
            answer.add(level);
            flag=!flag;
        }
        return answer; 
    }

    public static void main(String args[]) {

        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
      
        List<List<Integer>> maxWidth = ZigZagLevelOrderTraversal(root);
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