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
    int pos = 0;
    
    public TreeNode bst(int startInOrder, int endInOrder, ArrayList<Integer> preOrder, ArrayList<Integer> inOrder){
        
        if(startInOrder > endInOrder){
            return null;
        }
        
        TreeNode node = new TreeNode(preOrder.get(pos--));
         
        if(startInOrder == endInOrder){
            return node;
        }
        
        //Do node .val and not PostOrder[Pos]
        int index = findIndexInorder(inOrder, node.val,startInOrder, endInOrder);
        
        //Important - node.right is before node.left
        node.right = bst(index+1, endInOrder, preOrder, inOrder);
        node.left = bst(startInOrder, index-1, preOrder, inOrder);
        
        
        return node;
        
    }
    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> preOrder) {
        pos = preOrder.size()-1;
        return bst(0, preOrder.size()-1,preOrder,inOrder);
    }
    
    public int findIndexInorder(ArrayList<Integer> B, int ele, int start, int end){
        
        int i;
        for(i  = start; i <= end ;i++){
            if(B.get(i) == ele){
                return i;
            }
        }
        
        return i;
    }
}
