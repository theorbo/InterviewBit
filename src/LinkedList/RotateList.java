/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        
        ListNode start = A, current = A, prev = A, newStart = A;
        
        int len = lengthList(A);
        
        if(len == 1){
            return start;
        }
        
        //No need to rotate
        else if(B%len == 0){
           return start; 
        }
        
        else{
        int count = len - (B%len);
        
        while(count > 0){
            prev = current;
            current = current.next;
            
            count --;
        }
        
        prev.next = null;
        newStart = current;
        
        while(current.next != null){
            current = current.next;
        }
        current.next = start;
        
        return newStart;
        }
        
    }
    
    public int lengthList(ListNode A){
        
        int count = 0;
        while(A != null){
            A = A.next;
            count++;
        }
        
        return count;
    }
}
