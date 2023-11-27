// Leetcode - https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree

package Tree;

public class avgOfSubtree {
    private  static int count = 0;

    private static int[] dfs(TreeNode curr){
        if(curr==null){
            return new int[]{0,0};
        }

        int[] leftSubtree = dfs(curr.left);
        int[] rightSubtree = dfs(curr.right);

        int sumOfValues = leftSubtree[0] + rightSubtree[0] + curr.val;
        int sumOfNodes = leftSubtree[1] + rightSubtree[1] + 1;

        if(sumOfValues/sumOfNodes == curr.val){
            count++;
        }
        
        return new int[]{sumOfValues,sumOfNodes};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }
    
}
