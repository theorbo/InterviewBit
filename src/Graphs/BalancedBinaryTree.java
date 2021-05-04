/* Given a binary tree, determine if it is height-balanced.Return 0 / 1 ( 0 for false, 1 for true ) for this problem*/

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
    
    private Map<TreeNode,Integer> mp;
     public int isBalanced(TreeNode A) {
        mp = new HashMap<>();
        return  balanced(A) ? 1 : 0;
        
    }
    
    private int height(TreeNode A){
        if(A == null)
            return 0;
            
        if(mp.containsKey(A))
            return mp.get(A);
            
        int he = 1+Math.max(height(A.left), height(A.right));
        mp.put(A, he);
        
        return he;    
    }
    
    private boolean balanced(TreeNode A){
        if(A == null)
        return true;
        int value = Math.abs(height(A.left) - height(A.right));
        if(balanced(A.left) && balanced(A.right) && value <= 1)
        return true;
        return false;
    }
}
