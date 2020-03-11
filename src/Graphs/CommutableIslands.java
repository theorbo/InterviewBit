public class Solution {
    
    Map<Integer, DSNode> nodeMap = new HashMap<>();;
    class DSNode{
        int val;
        int rank;
        DSNode parent;
        DSNode(int val){
            this.val = val;
            this.rank = 0;
            this.parent = this;
        }
    }
    
    public void makeSet(int A){
 
           DSNode dsNode = new DSNode(A);
           nodeMap.put(A, dsNode);
    }
    
    public DSNode findSet(int a){
        
        if(!nodeMap.containsKey(a))
            return null;
        
        DSNode node = nodeMap.get(a);
        DSNode tempNode = findParent(node);
        node.parent = tempNode;
        return tempNode;
    }
    
    public DSNode findParent(DSNode node){
        
        while(node.parent != node){
            node = node.parent;
        }
        return node;
    }
    
    
    public void union(int a, int b){
        
        if(!nodeMap.containsKey(a) || !nodeMap.containsKey(b)){
            return;
        }
        
        DSNode parentA = findSet(a);
        DSNode parentB = findSet(b);
        
        if(parentA.rank > parentB.rank){
            parentB.parent = parentA;
        }
        else if(parentA.rank == parentB.rank){
            parentB.parent = parentA;
            parentA.rank += 1;
        }
        else {
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
    public int solve(int A, int[][] B) {
        
        Arrays.sort(B, (a, b) -> Integer.compare(a[2], b[2]));
        
        int totalCost = 0;
        
        int i;
        for(i = 1; i <= A; i++){
            makeSet(i);
        }
        int count = 0;
        
        for(i = 0; i < B.length; i++){
            
            if(!isCycleFormed(B[i][0],B[i][1])){
                totalCost += B[i][2];
                count++;
                if(count ==  A-1)
                    break;
            }
        }
        
        return totalCost;
        
    }
}
