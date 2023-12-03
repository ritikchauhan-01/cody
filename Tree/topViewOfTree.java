package Tree;
import java.util.*;


public class topViewOfTree {
    private static List<Integer> dfs(TreeNode root){
        class Pair {
            TreeNode node;
            int hd;
 
            Pair(TreeNode node, int hd)
            {
                this.node = root;
                this.hd = hd;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.hd;
            TreeNode temp = it.node;
            if(map.get(hd)==null){
                map.put(hd,temp.val);
            }
            if(temp.left!=null){
                q.add(new Pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.add(new Pair(temp.right,hd+1));
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    // main call
    public static List<Integer> topView(TreeNode root){
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