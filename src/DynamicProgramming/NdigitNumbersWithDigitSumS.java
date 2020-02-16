/**
Find out the number of N digit numbers, whose digits on being added equals to a given number S.
Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
Since the answer can be large, output answer modulo 1000000007
*/

public class Solution {
   
    static int lookup[][]; 
    static long MOD = 1000000007;
      
    // Memoization based implementation of recursive 
    // function 
    static int countRec(int n, int sum) 
    { 
        // Base case 
        if (n == 0) 
        return sum == 0 ? 1 : 0; 
      
        // If this subproblem is already evaluated, 
        // return the evaluated value 
        if (lookup[n][sum] != -1) 
        return lookup[n][sum]; 
      
        // Initialize answer 
        long ans = 0; 
      
        // Traverse through every digit and 
        // recursively count numbers beginning 
        // with it 
        for (int i=0; i<10; i++) 
        if (sum-i >= 0) 
            ans += countRec(n-1, sum-i)%MOD; 
      
        return lookup[n][sum] = (int)(ans%MOD); 
    } 
      
    // This is mainly a wrapper over countRec. It 
    // explicitly handles leading digit and calls 
    // countRec() for remaining n. 
    public static int solve(int n, int sum) 
    { 
        lookup = new int[n+1][sum+1];
        // Initialize all entries of lookup table 
        for(int i = 0; i <= n; ++i){ 
            for(int j = 0; j <= sum; ++j){ 
                lookup[i][j] = -1; 
            } 
        } 
      
        // Initialize final answer 
        long ans = 0; 
      
        // Traverse through every digit from 1 to 
        // 9 and count numbers beginning with it 
        for (int i = 1; i <= 9; i++) 
        if (sum-i >= 0) 
            ans += countRec(n-1, sum-i)%MOD; 
        return (int)(ans%MOD); 
    } 
}
