/* Given any source point, (C, D) and destination point, (E, F) on a chess board, we need to find whether Knight can move to the destination or not.

Knight's movements on a chess board

The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1.

Note: A knight cannot go out of the board.

*/

public class Solution {
   
    public int knight(int A, int B, int C, int D, int E, int F) {
        return getMinimumDistance(A,B, E, F, C,D);
    }
    
    class Cell{
        int x, y, cost;
        Cell(int x, int y , int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public int getMinimumDistance(int m, int n, int Xfinal, int Yfinal, int Xcurr, int Ycurr){
        
        boolean[][] visited = new boolean[m+1][n+1];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(Xcurr, Ycurr, 0));
        visited[Xcurr][Ycurr] = true;
        
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};  
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        
        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            if(cell.x == Xfinal && cell.y == Yfinal){
                return cell.cost;
            }
                
            for(int i = 0; i < dx.length ; i++){
                int xval = cell.x + dx[i];
                int yval = cell.y + dy[i];
                
                if(isValid(xval, yval, m, n) && !visited[xval][yval]){
                    visited[xval][yval] = true;
                    queue.add(new Cell(xval, yval, cell.cost+1));
                }
            }        
            
        }
        return -1;
      
    }
    
    private boolean isValid(int Xcurr, int Ycurr, int m, int n){
        if(Xcurr >=1 && Xcurr <= m && Ycurr >= 1 && Ycurr <= n)
            return true;
            
        return false;    
    }
}
