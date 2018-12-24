public class Solution {
    public int coverPoints(int[] A, int[] B) {
        
        int startX = A[0];
        int startY = B[0];
        
        int ans = 0;
        
        for(int i = 1; i < A.length; i++){
            
            int diffX = A[i] - startX;
            int diffY = B[i] - startY;
            
            ans += Math.max(diffX, diffY);
            
            startX = A[i];
            startY = B[i];
        }
        
        return ans;
    }

}
