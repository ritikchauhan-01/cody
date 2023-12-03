//vedio link -https://www.youtube.com/watch?v=0FtVY6I4pB8&ab_channel=takeUforward

package Tree;
import java.util.*;

public class bottomViewOfTree {

    private static List<Integer> dfs(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        root.hd= 0;
        q.add(root);

        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            int hd = temp.hd;
            map.put(hd, temp.val);
            if(temp.left!=null){
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        } 
        return ans;
    }

    public List<Integer> bottomView(TreeNode root){
        return dfs(root);
    }
}

class TreeNode {
      int val;
      int hd;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, int hd, TreeNode left, TreeNode right) {
          this.val = val;
          this.hd=hd;
          this.left = left;
          this.right = right;
    }
}


    
