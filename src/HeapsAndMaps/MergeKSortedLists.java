/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        
        int k = a.size();
        
        ListNode start = MIN(a);
        a = movePointer(a, start);
        
        ListNode temp = start;
        
        while(true){
            
            if(MIN(a) == null){
                break;
            }
            else{
                temp.next = MIN(a);
                temp = temp.next;
                a = movePointer(a, temp);
                
            }
            
        }
        
        return start;
    }
    
    public ListNode MIN(ArrayList<ListNode> a){
        
        int min = Integer.MAX_VALUE;
        ListNode result = null;
        
        for(int i = 0; i < a.size(); i++){
            
            ListNode node = a.get(i);
            
            if(node != null){
                if(node.val < min){
                    min = node.val;
                    result = node;
                }
                
            }
        }
        
        return result;
    }
    
    public ArrayList<ListNode> movePointer(ArrayList<ListNode> a, ListNode b){
        
        for(int i = 0; i < a.size(); i++){
            
            if(a.get(i) != null){
                if(a.get(i).equals(b)){
                a.set(i, a.get(i).next);
                break;
                }
            }
            
        }
       return a; 
    }
}
