// link  - 

public class ChildrenSum {

    public static void reorder(Node root){
        if(root.left==null) return;
        int child = 0;
        
        if(root.left!=null){
            child += root.left.data;
        }

        if(root.right!=null){
            child += root.right.data;
        }

        if(child<root.data){
            if(root.left!=null) root.left.data = root.data;
            else if(root.right!=null) root.right.data = root.data;
        }

        reorder(root.left);
        reorder(root.right);
        
        int total = 0;
        if(root.left!=null) total += root.left.data;
        if(root.right!=null) total += root.right.data;
        if(root.left!=null || root.right!=null) root.data = total;
    }

    public static void changeTree(Node root){
        reorder(root);
    }
    
    public static void main(String args[]) {

        Node  root = new Node(2);
        root . left = new Node(35);
        root . left . left = new Node(2);
        root . left . right = new Node(3);
        root . right = new Node(10);
        root . right . left = new Node(5);
        root . right . right = new Node(2);
      
        changeTree(root);
      
      }
    
}

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}