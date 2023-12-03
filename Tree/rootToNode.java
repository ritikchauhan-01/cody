package Tree;
import java.util.*;

class rootToNode {
    static boolean dfs(Node root, ArrayList<Integer> arr, Integer x){
        if (root == null)
            return false;

        // push the node's value in 'arr'
        arr.add(root.data);

        if (root.data == x)
            return true;

        if (dfs(root.left, arr, x) ||
            dfs(root.right, arr, x))
            return true;

        arr.remove(arr.size() - 1);
        return false;
    }



    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        ArrayList < Integer > arr = new ArrayList < > ();

        boolean res = dfs(root, arr, 7);

        System.out.print("The path is ");
        for (int it: arr) {
            System.out.print(it + " ");
        }
    }
}

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
