/*
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE”
while “AEC” is not).
https://www.interviewbit.com/problems/distinct-subsequences/
*/

public class Solution {
    public int numDistinct(String A, String B) {
        
        int m = A.length();
        int n = B.length();
        int i,j;
        int[][] dp = new int[m+1][n+1];
        
        for(i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        
        for(i = 1; i <= m ; i++){
            for(j = 1; j <= n; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
