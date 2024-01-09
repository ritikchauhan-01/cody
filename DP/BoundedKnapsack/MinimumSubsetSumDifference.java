//Link - https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

package DP.BoundedKnapsack;
import java.util.*;

public class MinimumSubsetSumDifference {

    public static int helper(int[] nums, int range){
        boolean[][] dp = new boolean[nums.length+1][range+1];

        for(int i=0;i<range+1;i++)
            dp[0][i] = false;
        
        for(int i=0;i<nums.length;i++)
            dp[i][0] = true;

        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<range+1;j++){
                if(nums[i-1]<=j)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        List<Integer> check = new ArrayList<>();
        for(int i=1;i<=range/2;i++){
            if(dp[nums.length][i]==true)
                check.add(i);
        }

        System.out.println(check);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<check.size();i++){
            min = Math.min(min, range-(2*check.get(i)));
        }
            
        return min;
    }

    public static int minSubsetSumDifference(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int result = helper(nums,sum);
        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,2,7};
        System.out.println(minSubsetSumDifference(arr));
    }
    
}
