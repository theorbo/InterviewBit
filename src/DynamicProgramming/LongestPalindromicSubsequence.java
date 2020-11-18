/* Given a string A, find the common palindromic sequence ( A sequence which does not need to be contiguous and is a pallindrome), which is common in itself.

You need to return the length of longest palindromic subsequence in A. */



public class Solution {
    
    public int lcs(char[] X, char[] Y, int m, int n){
        
        int L[][] = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                
                if(X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }
    
    public int solve(String A) {
        StringBuilder input1 = new StringBuilder(A);
    
        String B = input1.reverse().toString();
        return lcs(A.toCharArray(), B.toCharArray(), A.length(), A.length());
    }
}
