// link - https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/

package Tree;
import java.util.*;

public class BoundaryTraversal {

    public static Boolean isLeaf(Node root){
        return (root.left==null) && (root.right==null);
    }

    public static void addLeftBoundary(Node root, ArrayList<Integer> ans){
        Node curr = root.left;
        while(curr!=null){
            if(isLeaf(curr)==false) ans.add(curr.data);
            if(curr.left!=null) curr = curr.left;
            else curr= curr.right;
        }
    }

    public static void addRightBoundary(Node root, ArrayList<Integer> ans){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }

        for(int i=temp.size()-1;i>=0;--i){
            ans.add(temp.get(i));
        }
    }
    
    public static void addLeaves(Node root, ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }

        if(root.left!=null) addLeaves(root.left, ans);
        if(root.right!=null) addLeaves(root.right, ans);
    }

    


    public static ArrayList<Integer> printBoundary(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList < Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
        System.out.println();
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