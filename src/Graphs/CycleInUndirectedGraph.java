/* Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.  */


public class Solution {
    public int solve(int A, int[][] B) {
        for(int i = 1; i <=A ; i++){
            makeSet(i);
        }
        
        for(int i = 0; i < B.length; i++){
            
            if(isCycleFormed(B[i][0], B[i][1]))
                return 1;
        }
        return 0;
    }
    
    class DsNode{
        int val;
        int rank;
        DsNode parent;
        DsNode(int val){
            this.val = val;
            this.rank = 0;
            this.parent = this;
        }
    }
    Map<Integer, DsNode> mp = new HashMap<>();
    private void makeSet(int val){
        DsNode node = new DsNode(val);
        node.rank = 0;
        node.parent = node;
        mp.put(val,node);
    }
    private DsNode findSet(int val){
        
        if(!mp.containsKey(val))
            return null;
            
        DsNode temp = mp.get(val);  
        DsNode node = temp;
            
        while(node.parent != node){
            node = node.parent;
        }    
        temp.parent = node;
        return node;
    }
    
    private void union(int A, int B){
        
        DsNode parentA = findSet(A);
		DsNode parentB = findSet(B);

		if(parentA.rank > parentB.rank)
			parentB.parent = parentA;

		else if(parentA.rank == parentB.rank){
			parentB.parent = parentA;
			parentA.rank += 1;
		} else {
			parentA.parent = parentB;
		}
    }
    
    public boolean isCycleFormed(int a, int b){
        if(findSet(a) == findSet(b)){
            return true;
        }
        union(a,b);
        return false;
    }
}
