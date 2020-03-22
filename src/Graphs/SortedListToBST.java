/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode a) {
	    
	  List<Integer> list = new ArrayList<>();
	  
	  if(a == null)
	    return null;
	  
	  while(a != null){
	      list.add(a.val);
	      a = a.next;
	  }
	    
	  return   constructBST(list, 0, list.size()-1);
	}
	
	public TreeNode constructBST(List<Integer> list, int low, int high){
	    
	    if(low > high)
	        return null;
	   
	    
	    int mid = low + (high - low)/2;
	    
	    TreeNode root = new TreeNode(list.get(mid));
	    root.left = constructBST(list, low, mid-1);
	    root.right = constructBST(list, mid+1, high);
	    return root;
	    
	}
}
