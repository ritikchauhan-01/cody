package Tree;

import java.util.ArrayList;
import java.util.List;

// TC - o(n) & SC = height of tree
public class leftViewOfTree {
    public void dfs(TreeNode root,List<Integer> ans, int level){
        if(root==null){
            return;
        }
        if(level==ans.size()){
            ans.add(root.val);
        }
        dfs(root.left, ans, level+1);
        dfs(root.right, ans, level+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans,0);
        return ans; 
    }
}
