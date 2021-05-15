/* Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible. */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        
        int[] maxarray = new int[A.length];
        int[] minarray = new int[A.length];
        maxarray[0] = A[0];
        minarray[0] = A[0];
        int result = A[0];
        
        for(int i = 1 ; i < A.length; i++){
            
            if(A[i]>0){
                maxarray[i] = Math.max(A[i],maxarray[i-1]*A[i]);
                minarray[i] = Math.min(A[i],minarray[i-1]*A[i]);
            }else{
                maxarray[i] = Math.max(A[i],minarray[i-1]*A[i]);
                minarray[i] = Math.min(A[i],maxarray[i-1]*A[i]);
            }
            result = Math.max(result,maxarray[i]);
        }
        return result;
    }
}
