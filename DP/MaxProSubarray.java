// Leetcode - https://leetcode.com/problems/maximum-product-subarray

package DP;

public class MaxProSubarray {
   
    // TC = O(n^2)
    public static int maxProductSubArray(int[] nums){
        int max = Integer.MIN_VALUE;;
        for(int i=0;i<nums.length;i++){
            int ans = nums[i];
            max = Math.max(max,ans);
            for(int j=i+1;j<nums.length;j++){
                ans *= nums[j];
                max = Math.max(max,ans);
            }
        }
        return max;
    }

    // optimized soln TC -> O(n)
    public static int maxProductSubArray1(int[] nums){
        int max = Integer.MIN_VALUE;
        int pre=1, suff=1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre *= nums[i];
            suff *= nums[n-i-1];
            max = Math.max(max, Math.max(pre,suff));        
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer = maxProductSubArray(arr);
        System.out.println("The maximum product subarray is: " + answer);
        int[] arr1 = {-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4};
        int answer1 = maxProductSubArray1(arr1);
        System.out.println("The maximum product subarray 1 is: " + answer1);
    }
}
