/** Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]*/


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
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        
        result = new ArrayList<ArrayList<Integer>>();
        paths(A, new ArrayList<Integer>(), 0, B);
        return result;
    }
    
    private void paths(TreeNode A, ArrayList<Integer> pathNodes, int currentSum, int targetSum){
        
        if(A == null)
            return;
            
        pathNodes.add(A.val);
        currentSum += A.val;
        
        if(A.left == null && A.right == null){
            if(currentSum == targetSum){
               //Copying Nodes
                ArrayList<Integer> a=new ArrayList<Integer>();
                for(int i = 0; i < pathNodes.size(); i++){
                    a.add(pathNodes.get(i));
                }
                result.add(a);
            }
        }  
        
        paths(A.left, pathNodes, currentSum, targetSum);
        paths(A.right, pathNodes, currentSum, targetSum);
        pathNodes.remove(pathNodes.size()-1);
        
    }
}

