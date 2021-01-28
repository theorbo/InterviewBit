/**
Two kingdoms are on a war right now, kingdom X and kingdom Y. As a war specialist of kingdom X, you scouted kingdom Y area.

A kingdom area is defined as a N x M grid with each cell denoting a village.
Each cell has a value which denotes the strength of each corresponding village.
The strength can also be negative, representing those warriors of your kingdom who were held hostages.

There’s also another thing to be noticed.

The strength of any village on row larger than one (2<=r<=N) is stronger or equal to the strength of village which is exactly above it.
The strength of any village on column larger than one (2<=c<=M) is stronger or equal to the strength of vilage which is exactly to its left.
(stronger means having higher value as defined above).
So your task is, find the largest sum of strength that you can erase by bombing one sub-matrix in the grid.
*/


public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        int ans = 0;
        int m = A.size();
        int n = A.get(0).size();
        int i, j;
        for(i = m-1; i >= 0; i--){
            for(j = n-1; j >= 0; j--){
                int sum = A.get(i).get(j);
                if( i+1 < m)
                sum += A.get(i+1).get(j);
                
                if(j+1 < n)
                sum += A.get(i).get(j+1);
                
                if(i+1 <m && j+1 < n)
                sum -= A.get(i+1).get(j+1);
                
                A.get(i).set(j, sum);
                ans = Math.max(ans,sum);
            }
        }
         if(ans  == 0){
            ans = A.get(m-1).get(n-1);
        }
        return ans;
    }
}
