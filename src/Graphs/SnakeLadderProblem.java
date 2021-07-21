/* Rishabh takes out his Snakes and Ladders Game, stares the board and wonders: "If I can always roll the die to whatever number I want, what would be the least number of rolls to reach the destination?"

RULES:

The game is played with cubic dice of 6 faces numbered from 1 to A.
Starting from 1 , land on square 100 with the exact roll of the die. If moving the number rolled would place the player beyond square 100, no move is made.
If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.
If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.
BOARD DESCRIPTION:

The board is always 10 x 10 with squares numbered from 1 to 100.
The board contains N ladders given in a form of 2D matrix A of size N * 2 where (A[i][0], A[i][1]) denotes a ladder that has its base on square A[i][0] and end at square A[i][1].
The board contains M snakes given in a form of 2D matrix B of size M * 2 where (B[i][0], B[i][1]) denotes a snake that has its mouth on square B[i][0] and tail at square B[i][1].*/

public class Solution {
    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {

    Map<Integer, Integer> values = new HashMap<>();

    // ladder
    for (int i = 0; i < A.size(); i++) {
      values.put(A.get(i).get(0), A.get(i).get(1));
    }

    for (int i = 0; i < B.size(); i++) {
      values.put(B.get(i).get(0), B.get(i).get(1));
    }

    return bfsTraversal(values);
  }

  private int bfsTraversal(Map<Integer, Integer> values) {

    boolean[] visited = new boolean[100 + 1];
    // LinkedList extends Queue interface. Hence Linked List is used.
    Queue<Vertex> queue = new LinkedList<>();
    Vertex root = new Vertex(1, 0);
    visited[1] = true;
    queue.add(root);

    while (!queue.isEmpty()) {

      Vertex current = queue.poll();
      int v = current.number;

      if (values.containsKey(v)) {
        v = values.get(v);
      }
      if (v == 100) {
        return current.distance;
      }

      for (int j = v + 1; j <= v + 6 && j <= 100; j++) {

        if (!visited[j]) {
          Vertex ver = new Vertex(j, current.distance + 1);
          visited[j] = true;
          queue.add(ver);
        }
      }
    }

    return -1;
  }

  class Vertex {
    int number;
    int distance;

    Vertex(int number, int distance) {
      this.number = number;
      this.distance = distance;
    }
  }
  
}
