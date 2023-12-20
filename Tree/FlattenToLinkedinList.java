// link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
package Tree;

public class FlattenToLinkedinList {

    public static Node prev = null;

    public static void flatten(Node root){
        Node curr = root;
        while(curr!=null){
            if(curr.left!=null){
                Node pre = curr.left;
                while(pre.right!=null){
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }


    public static void main(String args[]) {

        Node  root = new Node(1);
        root . left = new Node(2);
        root . left . left = new Node(3);
        root . left . right = new Node(4);
        root . right = new Node(5);
        root . right . right = new Node(6);
        root . right . right . left = new Node(7);
        flatten(root);
        while(root.right!=null)
        {
            System.out.print(root.data+"->");
            root=root.right;
        }
    System.out.print(root.data);
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
