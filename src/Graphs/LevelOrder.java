/**
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.

*/

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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(true){
            
            int nodeCount = queue.size();
            if(nodeCount <= 0)
            break;
            
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while(nodeCount > 0){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                queue.add(node.left);
                }
                if(node.right != null){
                queue.add(node.right);
                 }
                 
                 nodeCount --;
            }
            result.add(temp);
        }  
        return result;
    } 
}
