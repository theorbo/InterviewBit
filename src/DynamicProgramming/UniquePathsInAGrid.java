package DynamicProgramming;

import java.util.ArrayList;

public class UniquePathsInAGrid {

	int[][] t;
    public int uniquePathsWithObstacles(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        t = new int[m+1][n+1];

        return unique_paths_DP(m, n, A);
    }
    
    public int unique_paths_DP(int m, int n , int[][] A){
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                
                if(A[i-1][j-1] == 1)
                    t[i][j] = 0;
                else if(i==1 && j == 1)
                    t[i][j] = 1;
                else
                    t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }
        return t[m][n];
        
    }

}
