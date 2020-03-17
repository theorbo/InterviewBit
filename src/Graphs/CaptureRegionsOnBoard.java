/* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
Input Format:
    First and only argument is a N x M character matrix A
Output Format:
    make changes to the the input only as matrix is passed by reference.
Constraints:
    1 <= N,M <= 1000
For Example:
Input 1:
    A = [ [X, X, X, X],
          [X, O, O, X],
          [X, X, O, X],
          [X, O, X, X] ]
Output 1:
    After running your function, the board should be:
    A = [ [X, X, X, X],
          [X, X, X, X],
          [X, X, X, X],
          [X, O, X, X] ]
Explanation:
    O in (4,2) is not surrounded by X from below.  */
    

public class Solution {
    int M,N;
    public void solve(ArrayList<ArrayList<Character>> a) {
        
        replaceSurrounded(a);
    }
    
    // This method replaces all O with - and then calls dfs for 
    public void replaceSurrounded(ArrayList<ArrayList<Character>> a){
       
        M = a.size();
        N = a.get(0).size();
        int i, j;
        //Replace all O with -
        for(i = 0; i < M; i++){
            for(j = 0; j < N; j++){
                if(a.get(i).get(j) == 'O'){
                    a.get(i).set(j, '-');
                }
            }
        }
        
        //Calling dfs for all boundary -
        
        for(i = 0; i < M; i++){
            //left side
            if(a.get(i).get(0) == '-'){
                dfs(a,i,0,'-','O');
            }
            //right side
            if(a.get(i).get(N-1) == '-'){
                dfs(a,i,N-1,'-','O');
            }
        }
        
        
        for(i = 0; i < N; i++){
            //top
            if(a.get(0).get(i) == '-'){
                dfs(a,0,i,'-','O');
            }
            
            if(a.get(M-1).get(i) == '-'){
                dfs(a,M-1,i,'-','O');
            }
        }
        
        //Replace all - with X
        for(i = 0; i < M; i++){
            for(j = 0 ; j < N; j++){
                if(a.get(i).get(j) == '-')
                    a.get(i).set(j, 'X');
            }
        }
            
        
    }
    
    public void dfs(ArrayList<ArrayList<Character>> a, int x, int y, char prevC, char newC){
        
        if(x < 0|| x >= M || y < 0 || y >= N)
            return;
        
        if(a.get(x).get(y) != prevC)
            return;
        
        a.get(x).set(y, newC);
        
        dfs(a,x+1,y,prevC,newC);
        dfs(a,x-1,y,prevC,newC);
        dfs(a,x,y+1,prevC,newC);
        dfs(a,x,y-1,prevC,newC);
        
    }
}
