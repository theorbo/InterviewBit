/** Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B. */

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
    public ArrayList<Integer> solve(TreeNode A, int B) {
        
     ArrayList<Integer> res = new ArrayList<>();
    solve(A,B,res);
    return res;
    }
    
    public boolean  solve(TreeNode root, int n, ArrayList<Integer> res ){
    if(root == null) return false;
    res.add(root.val);
    if(root.val == n) return true;
    if(solve(root.left,n,res) || solve(root.right,n,res)) return true;
    res.remove(res.size() -1);
    return false;
}
}
