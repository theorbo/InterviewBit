/**
Given A, B, C, find whether C is formed by the interleaving of A and B.
*/

public class Solution {
    public int isInterleave(String A, String B, String c) {
        
        int la = A.length();
        int lb = B.length();
        int lc = c.length();
        
        int[][] dp = new int[la+1][lb+1];
        
        if(la+lb != lc)
            return 0;
        
        int i, j;
        
        for(i = 0; i <= la; i++){
            for(j = 0; j <= lb; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else if(i == 0){
                    dp[i][j] = dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else if(A.charAt(i-1) == c.charAt(i+j-1) && c.charAt(i+j-1) != B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j];
                }
                else if(B.charAt(j-1) == c.charAt(i+j-1) && c.charAt(i+j-1) != A.charAt(i-1)){
                    dp[i][j] = dp[i][j-1];
                }
                else if(A.charAt(i-1) == c.charAt(i+j-1) && c.charAt(i+j-1) == B.charAt(j-1)){
                    if(dp[i-1][j] == 1 || dp[i][j-1] == 1){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
                
            }
        }
        return dp[la][lb];
        
    }    
}
