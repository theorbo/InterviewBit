public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int i, sum = 0, carry = 1, k = 0;
        
        for(i = A.size()-1; i >= 0; i--){
            
            sum = A.get(i) + carry;
            carry = sum/10;
            ans.add(sum % 10);
            
        }
        if(carry != 0){
            ans.add(carry);
        }
        
        Collections.reverse(ans);
        ArrayList<Integer> ansFinal = new ArrayList<>();
        for( i = 0; i < ans.size(); i++) {
            if(ans.get(i) == 0){
                k++;
            }
            else {
                break;
            }
        }
        
         for( i = k; i < ans.size(); i++) {
            ansFinal.add(ans.get(i));
        }
        
        return ansFinal;
    }
}
