package Tree;
import java.util.*;

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.num = num;
        this.node = node;
    }
}


public class allTraversal {
    static void preInPostTraversal(TreeNode root, List<Integer> preorder, List<Integer> inorder, List<Integer> postorder){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        if(root==null) return ;

        while(!st.isEmpty()){
            Pair it = st.pop();
            
            if(it.num == 1){
                preorder.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.left!=null){
                    st.push(new Pair(it.node.left,1));
                }
            }
            if(it.num==2){
                inorder.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.right!=null){
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                postorder.add(it.node.val);
            }

        }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List < Integer > pre = new ArrayList < > ();
        List < Integer > in = new ArrayList < > ();
        List < Integer > post = new ArrayList < > ();
        preInPostTraversal(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
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

