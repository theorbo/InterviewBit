/**
 There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
 Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

 Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 */

public class Solution {
  int XX[] = {1, 1, 0, 1, 0, -1, -1, -1};
  int YY[] = {0, 1, 1, -1, -1, -1, 0, 1};
  int[][] dp;

  public String solve(int x, int y, int N, int R, ArrayList<Integer> A, ArrayList<Integer> B) {
    dp = new int[x+1][y+1];

    for(int i = 0; i <= x; i++){
      for(int j = 0; j <= y; j++){
        dp[i][j] = 0;
      }
    }

    int result = doWork(0,0,x,y,N,R,A,B);

    if(result == 1){
      return "YES";
    }
    return "NO";

  }

  public int doWork(int Xmove, int Ymove, int x, int y, int N, int R, ArrayList<Integer> A, ArrayList<Integer> B){

    if(!isValidRectangle(x, y, Xmove, Ymove)){
      return -1;
    }
    if(dp[Xmove][Ymove] != 0){
      return dp[Xmove][Ymove];
    }

    if(isInsideCircle(N,R,A,B,Xmove,Ymove)){
      dp[Xmove][Ymove]=-1;
      return dp[Xmove][Ymove];
    }

    if(Xmove == x && Ymove == y){
      dp[Xmove][Ymove] = 1;
      return dp[Xmove][Ymove];
    }
    else{
      dp[Xmove][Ymove] = -1;
      for(int i = 0; i < 8; i++){
        if(doWork(Xmove+XX[i], Ymove+YY[i],x,y,N,R,A,B) == 1){
          dp[Xmove][Ymove]=1;
          return dp[Xmove][Ymove];
        }
      }
    }
    return dp[Xmove][Ymove];
  }

  public boolean isValidRectangle(int x, int y, int X, int Y){

    if(X >= 0 && X <= x && Y >= 0 && Y <= y){
      return true;
    }
    return false;
  }

  public boolean isInsideCircle(int N, int R, ArrayList<Integer> A, ArrayList<Integer> B, int x, int y){

    for(int i = 0; i < N; i++){

      int a = A.get(i);
      int b = B.get(i);

      int val = (x-a)*(x-a) + (y-b)*(y-b);

      if(val <= (R*R)){
        return true;
      }
    }
    return false;
  }
}
