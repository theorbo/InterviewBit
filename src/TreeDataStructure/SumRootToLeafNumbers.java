/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    public static int totalSum = 0;
    int mod = 1003;
    
    public int findPathSum(TreeNode A, int sum){
        
        if(A == null){
            return 0;
        }
        
        sum = ((sum*10)+A.val)%mod;
        
        if(A.left == null & A.right == null){
            totalSum += sum;
            totalSum = (totalSum)%mod;
        }
        
        else{
            
            findPathSum(A.right, sum);
            findPathSum(A.left, sum);
            
        }
        
        return totalSum;
 
    }
    
    public int sumNumbers(TreeNode A) {
        totalSum = 0;
        return findPathSum(A, 0);
        
    }
    
}
