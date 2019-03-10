public class Solution {
    
    int dp[];
  
    public int canJump(ArrayList<Integer> A) {
        
        int len = A.size();
        dp = new int[len+1];
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        
        
        dp[len-1] = 1;
        for(int i = len-2; i >= 0; i--){
            int num =  Integer.valueOf(A.get(i));
            
            for(int j = 1; j <= num; j++){
                
                if(i+j < len){
                    dp[i] = dp[i+j];
                    if(dp[i] == 1){
                        break;
                    }
                }
            }
            
            if(dp[i] == -1){
                dp[i] = 0;
            }
        }
        
      
        return dp[0];
       
    }
}
