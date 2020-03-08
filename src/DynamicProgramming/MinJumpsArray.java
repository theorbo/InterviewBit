/* Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Return the minimum number of jumps required to reach the last index.
If it is not possible to reach the last index, return -1.

Input 1:
    A = [2, 1, 1]

Output 1:
    1
    
Explanation 1:
    The shortest way to reach index 2 is
        Index 0 -> Index 2
    that requires only 1 jump.

Input 2:
    A = [2,3,1,1,4]

Output 2:
    2

Explanation 2:
    The shortest way to reach index 4 is
        Index 0 -> Index 1 -> Index 4
    that requires 2 jumps. 
*/

Solution - O(n2)

public class Solution {
    public int jump(ArrayList<Integer> A) {
        
        int[] dp = new int[A.size()];
        int i, j;
        dp[0] = 0;
        
        for(i = 1; i < A.size(); i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(i = 1 ;i < A.size(); i++){
            for(j = 0; j < i; j++){
                
                if(dp[j] == Integer.MAX_VALUE){
                    return -1;
                }
                if(i <= j+A.get(j) && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        
        return dp[A.size()-1];
    }
}

/** O(n) solution */

public class Solution {
    public int jump(ArrayList<Integer> A) {
        if (A.size() <= 1)
            return 0;
        int jump=1;
        int step = A.get(0);
        int maxReach = A.get(0);
        
        for(int i = 1; i < A.size() ; i++){
            if (i == A.size()- 1)
                return jump;
            if(i+A.get(i) > maxReach){
                maxReach = i+A.get(i);
            }
            step--;
            
            if(step == 0){
                jump++;
                step = maxReach-i;
            }
            else if(step < 0){
                return -1;
            }
        }
        return jump;
    }
}

    
    
