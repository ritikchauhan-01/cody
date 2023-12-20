// link - 

package Tree;
import java.util.*;

public class MaxPathSum {

    public static int maxPathDown(Node root, int maxi[]){
        if(root==null) return 0;
        int left = Math.max(0,maxPathDown(root.left,maxi));
        int right = Math.max(0,maxPathDown(root.right, maxi));
        maxi[0] = Math.max(maxi[0],left+right+root.data);

        return Math.max(left,right) + root.data;
    }

    public static int maxPathSum(Node root){
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPathDown(root,maxi);
        return maxi[0];
    }

    public static void main(String args[]) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);

    }
    
}

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this .right = null;
    }
}
