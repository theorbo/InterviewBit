package DynamicProgramming;

import java.util.ArrayList;

public class UniquePathsInAGrid {

  public int findPaths(ArrayList<ArrayList<Integer>> A, int x, int y, int[][] dp, int m, int n){

    if(x == 0 && y == 0 && A.get(x).get(y) == 0){
      dp[x][y] = 1;
      return dp[x][y];
    }

    else if(x < 0 || x >= m || y < 0 || y >=n){
      return 0;
    }

    else if(A.get(x).get(y) == 1){
      dp[x][y] = 0;
      return dp[x][y];
    }

    else{
      dp[x][y] = findPaths(A,x,y-1,dp,m,n) + findPaths(A,x-1,y,dp,m,n);
      return dp[x][y];
    }

  }


  public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

    int m = A.size();
    int n = A.get(0).size();
    int[][] dp = new int[m][n];


    findPaths(A,m-1,n-1,dp,m,n);

    return dp[m-1][n-1];
  }

  public static void main(String args[]){

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    ArrayList<Integer> l1 = new ArrayList<>();
    l1.add(0);
    l1.add(0);
    l1.add(0);

    ArrayList<Integer> l2 = new ArrayList<>();
    l2.add(0);
    l2.add(1);
    l2.add(0);

    ArrayList<Integer> l3 = new ArrayList<>();
    l3.add(0);
    l3.add(0);
    l3.add(0);

    list.add(l1);
    list.add(l2);
    list.add(l3);


    UniquePathsInAGrid uniquePathsInAGrid = new UniquePathsInAGrid();

    System.out.println(uniquePathsInAGrid.uniquePathsWithObstacles(list));
  }

}
