/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    public static Stack<TreeNode> nodes; 

    public Solution(TreeNode root) {
        nodes = new Stack<TreeNode>();
        
      
        while(root != null){
            nodes.push(root);
            root = root.left;
        }
        
       
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        if(!nodes.isEmpty()){
            return true;
        }

        return false;
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode topNode = nodes.pop();
        
        TreeNode tempNode = topNode.right;
        
        while(tempNode != null){
            nodes.push(tempNode); 
            tempNode = tempNode.left;
        }
        
        return topNode.val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
