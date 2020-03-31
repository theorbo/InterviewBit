/** Given a binary tree, find its maximum depth.

 The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node.
 Example :

 1
 /
 2
 max depth = 2. */

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
  int depth = 0;
  public int maxDepth(TreeNode A) {

    if(A.left == null && A.right ==  null){
      return 1;
    }
    else if(A.left == null){
      depth = 1 + maxDepth(A.right);
    }
    else if(A.right ==  null){
      depth = 1 + maxDepth(A.left);
    }
    else {
      depth = 1 + Math.max(maxDepth(A.left), maxDepth(A.right));
    }

    return depth;

  }
}
