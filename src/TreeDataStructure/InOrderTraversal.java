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
    Stack<TreeNode> stack = new Stack<TreeNode>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if(A != null){
           stack.push(A);
        } 
       
        inorder(A);
        return result;
    }
    
    public void inorder(TreeNode A){
       
       while(stack.size() != 0 && A != null){
           
           while(A.left != null){
           stack.push(A.left);
           A = A.left;
           }
       
           TreeNode temp = stack.pop();
           result.add(temp.val);
       
           if(temp.right != null){
             stack.push(temp.right);
             A = temp.right;
           }
     
       }
       
    }
}
