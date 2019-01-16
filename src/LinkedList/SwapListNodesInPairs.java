public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        
      ListNode temp = A;
      
      while(temp != null && temp.next != null){
          
          int x = temp.val;
          temp.val = temp.next.val;
          temp.next.val = x;
          
          temp = temp.next.next;
      }
      
      return A;
    }
}
