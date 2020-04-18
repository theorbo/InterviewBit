/** Implement wildcard pattern matching with support for ‘?’ and ‘*’ for strings A and B.

’?’ : Matches any single character.
‘*’ : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Input Format:

The first argument of input contains a string A.
The second argument of input contains a string B.
Output Format:

Return 0 or 1:
    => 0 : If the patterns do not match.
    => 1 : If the patterns match. 
*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String s, final String p) {
        
        if(s==null && p==null) return 1;
        if(s==null || p==null) return 0;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=0;i<n;i++){
            if(p.charAt(i)=='*')
                dp[0][i+1] = true;
            else break;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p.charAt(j)!='*'){
                    dp[i+1][j+1] = dp[i][j] && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?');
                }
                else{
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }
        return dp[m][n]?1:0;
    }
}
   
   
