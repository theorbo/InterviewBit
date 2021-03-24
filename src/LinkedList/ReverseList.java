/**
Reverse a linked list. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        
        ListNode root = A;
        ListNode curr_ptr = A.next;
        ListNode prev = A;
        
        while(curr_ptr != null){
           prev.next = curr_ptr.next;
           curr_ptr.next = root;
           root = curr_ptr;
           curr_ptr = prev.next;
        }
        
        return root;
    }
}
