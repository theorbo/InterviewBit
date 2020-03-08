/* As it is Tushar’s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. 
A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. 
Find the minimum cost such that all of Tushar’s friends are satisfied (reached their eating capacity).
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    int[][] dp;
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        
        int totalCost = 0;
        for(int i = 0; i < A.size(); i++){
            int val =  knapSack(B,C,A.get(i));
            totalCost += val;
        }
        return totalCost;
    }
    
    public int knapSack(List<Integer> B, List<Integer> C, int capacity){
        int n = B.size();
        dp = new int[n+1][capacity+1];
        
        int i,j;
        long val = Integer.MAX_VALUE;
        
        for(i = 0; i <= n; i++){
            for(j = 0; j <= capacity; j++){
                dp[i][j] = (int)val;
            }
        }
        
        for (i = 0; i <= capacity; i++) 
            dp[0][i] = (int)val; 

        for (i = 1; i <= n; i++) 
            dp[i][0] = 0; 
         
        for(i = 1; i <= n; i++){
            for(j = 1; j <= capacity; j++){
                if(B.get(i-1) > j)
                    dp[i][j] = dp[i-1][j];
        
                else{
                    long val1 = Math.min((long)dp[i-1][j], (long)dp[i][j-B.get(i-1)] + (long)C.get(i-1));
                    dp[i][j] = (int)val1;
                }
                    
            }
        }
 
        return (dp[n][capacity] == Integer.MAX_VALUE) ? 1 : dp[n][capacity];
    }

}
