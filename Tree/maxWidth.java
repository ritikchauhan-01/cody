package Tree;
import java.util.*;

class maxWidth {
    public static int widthOfBinaryTree(TreeNode root){
        if(root==null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num; // this is used for overflow condn
            int first=0, last=0;
            for(int i=0;i<size;i++){
                int curr_id = q.peek().num-min;  // for overflow condn
                TreeNode node = q.peek().node;
                q.remove();
                if(i==0) first = curr_id;
                if(i==size-1) last = curr_id;
                if(node.left!=null){
                    q.add(new Pair(node.left, curr_id*2+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right, curr_id*2+1));
                }
            }
            ans = Math.max(ans,last-first+1);
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
      
        int maxWidth = widthOfBinaryTree(root);
        System.out.println("The maximum width of the Binary Tree is "+maxWidth);
    
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;

    }
}

class Pair{
    int num;
    TreeNode node;
    Pair(TreeNode node, int num){
        this.num = num;
        this.node = node;
    }
}

