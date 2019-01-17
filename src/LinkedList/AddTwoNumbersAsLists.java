public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        
        int sum = 0, carry = 0;
        ListNode ans = new ListNode(0);
        ListNode C = ans;
        
        while(A != null && B != null){
            sum = (A.val+B.val+carry)%10;
            carry = (A.val+B.val+carry)/10;
            
            C.next = new ListNode(sum);;
            
            C = C.next;
            A = A.next;
            B = B.next;
        }
        
        while(A == null && B != null){
            sum = (B.val+carry)%10;
            carry = (B.val+carry)/10;
            
            C.next = new ListNode(sum);
            
            C = C.next;
            B = B.next;
        }
        
        while(A != null && B == null){
            sum = (A.val+carry)%10;
            carry = (A.val+carry)/10;
            
            
            C.next = new ListNode(sum);
            
            C = C.next;
            A = A.next;
        }
        
        if(carry != 0){
           C.next = new ListNode(carry);
           C = C.next;
           
        }
        
        return ans.next;
    }
}
