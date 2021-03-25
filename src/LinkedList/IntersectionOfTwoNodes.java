/* Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

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
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a == null || b == null)
            return null;
        ListNode headA = a;
        ListNode headB = b;
        int sizeA = 0;
        int sizeB = 0;
        while(headA != null){
            headA = headA.next;
            sizeA++;
        }
        while(headB != null){
            headB = headB.next;
            sizeB++;
        }
        headA = a;
        headB = b;
        if(sizeA > sizeB){
            while(sizeA-sizeB > 0){
                headA = headA.next;
                sizeA--;
            }
        }else{
            while(sizeB - sizeA > 0){
                headB = headB.next;
                sizeB--;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
