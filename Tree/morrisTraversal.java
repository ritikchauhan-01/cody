package Tree;
import java.util.*;


// morris traversal for inorder , TC -> O(n) and SC -> O(1)
public class morrisTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                inorder.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
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


// morris traversal for preorder , TC -> O(n) and SC -> O(1)


// public List<Integer> preorderTraversal(TreeNode root){
//     List<Integer> preorder = new ArrayList<>();
//     TreeNode curr = root;
//     while(curr!=null){
//         if(curr.left==null){
//             preorder.add(curr.val);
//             curr = curr.right;
//         }
//         else{
//             TreeNode prev = curr.left;
//             while(prev.right!=null && prev.right!=curr){
//                 prev = prev.right;
//             }
//             if(prev.right==null){
//                 prev.right=curr;
//                 curr = curr.left;
//             }
//             else{
//                 prev.right = null;
//                 preorder.add(curr.val);
//                 curr = curr.right;
//             }
//         }
//     }
//     return preorder;
// }
