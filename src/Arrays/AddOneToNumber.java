public class Solution {
    public int[] plusOne(int[] A) {
       
       int[] B = new int[A.length+1];
       
       B[0] = 0;
       int i, len = B.length;
       
       for(i = 1; i < len; i++){
           B[i] = A[i-1];
       }
       int carry = 1;
       for(i = len -1; i >= 0; i--){
           
           int sum = (B[i]+carry)%10;
           carry = (B[i]+carry)/10;
           
           B[i] = sum;
           
       }
       
       if(B[0] != 0){
           return B;
       }
       else{
           int counter = 0;
           while(B[counter] == 0){
               counter++;
           }
           int[] Bnew = new int[len-counter];
           
           for(i = 0; i < len-counter; i++){
               Bnew[i] = B[i+counter];
           }
           return Bnew;
       }
        
    }
}
