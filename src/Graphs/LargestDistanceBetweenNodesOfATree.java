/** Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
          0
       /  |  \
      1   2   3
               \
                4  
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance. 
 */

public class Solution {
    
    ArrayList<ArrayList<Integer>> graph;
    public int solve(ArrayList<Integer> A) {
        
        //form the graph
        int root = formGraph(A.size(), A);
        
        //Find the node that is farthest from the root using bfs
        int u = bfs(root, A.size());
        
        //Find the maximum distance from farthest node using modified DFS
        return dfs(u, A.size());
    }
    
    //forms the Graph and returns the root.
    public int formGraph(int n, ArrayList<Integer> A){
        
        graph = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int root = -1;
        for(int i = 0; i < n; i++){
            int num = A.get(i);
            if(num == -1){
                root = i;
                continue;
            }
            //Since bi-directional graph
            graph.get(i).add(num);
            graph.get(num).add(i);
        } 
        return root;
    }
    
    
    public int bfs(int root, int n){
        
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        queue.add(root);
        int u = -1;
        while(queue.size() != 0){
            u = queue.poll();
            if(!visited[u]){
                visited[u] = true;
                for(int v : graph.get(u)){
                    if(!visited[v]){
                        queue.add(v);
                    }
                }
            }
        }
        return u;
    }
    
    public int dfs(int root, int n){
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> dist = new Stack<Integer>();
        boolean[] visited = new boolean[n];
        stack.push(root);
        dist.push(0);
        int u = -1;
        while(!stack.isEmpty()){
            u = stack.pop();
            int d = dist.pop();
            if(!visited[u]){
                visited[u] = true;
                for(int v : graph.get(u)){
                    if(!visited[v]){
                        max = Math.max(max, d+1);
                        stack.push(v);
                        dist.push(d+1);
                    }
                }
            }
        }
        return max;
    }
}
