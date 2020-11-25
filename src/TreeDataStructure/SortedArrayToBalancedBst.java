/* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        return bst(A, 0, A.length-1);
    }
    public TreeNode bst(int[] A, int start , int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = bst(A, start, mid-1);
        node.right = bst(A, mid+1, end);
        return node;
    }
}
