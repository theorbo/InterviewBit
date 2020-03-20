/** How many distinct Max Heap can be made from n distinct integers. */

public class Solution {
    long MOD = 1000000007;
  public int solve(int A) {
    long[][] ncr = calculateCombination(A,A);

    long[] dp = new long[A+1];
    dp[0] = dp[1] = 1;
    for(int i = 2; i <= A; i++){
      int left = leftSubtreeElements(i);
      // (n-1)CL * getNumberOfMaxHeaps(L) * getNumberOfMaxHeaps(R) 
      dp[i] = ncr[i-1][left]*dp[left]%MOD*dp[i-left-1]%MOD;
    }
    return (int)dp[A];
  }

  public long[][] calculateCombination(int n, int k){

    long[][] dp = new long[n+1][k+1];
    int i,j;

    for(i = 0 ; i <= n ;i++){
      for(j = 0; j <= k; j++){

        if(i == 0)
          dp[0][j] = 0;
        else if(j == 0|| i == j)
          dp[i][j] = 1;
        else
          dp[i][j] = dp[i-1][j]%MOD + dp[i-1][j-1]%MOD;
      }
    }

    return dp;
  }

  //Calculates the number of elements in the left subtree.
  public int leftSubtreeElements(int total_elements){
    if(total_elements == 1)
      return 0;

    int height = (int)log2(total_elements);
    int max_elements_last = (int)Math.pow(2,height);
    int actual_elements_last = total_elements - (max_elements_last-1);

    // If last level is more than half filled
    if(actual_elements_last >= max_elements_last/2)
      return (max_elements_last-1);

    // If last level is less than half filled
    return   (max_elements_last-1) - (max_elements_last/2 - actual_elements_last);
  }

  public static double log2(int n){
    return (Math.log(n) / Math.log(2));
  }

    
}
