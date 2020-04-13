/* Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
] */


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
    
    public ArrayList<ArrayList<Integer>> bfs(TreeNode A){
        
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> temp;
        queue.add(A);
        boolean flag = false;
        while(queue.size() > 0){
            temp = new ArrayList<>();
            int counter = queue.size();
            while(counter > 0){
            
            TreeNode tempNode = queue.poll();
            temp.add(tempNode.val);
            if(tempNode.left != null)
                queue.add(tempNode.left);
            if(tempNode.right != null)
                queue.add(tempNode.right);    
            counter --;
            }
            ArrayList<Integer> mem = new ArrayList<>();
            for(int i = 0; i< temp.size(); i++){
                mem.add(temp.get(i));
            }
            if(flag)
                Collections.reverse(mem);
            result.add(mem);
            flag = !flag;
        }
        
        return result;
        
        
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        
        return bfs(A);
    }
}
