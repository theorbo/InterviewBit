public class Solution {
    
    ArrayList<ArrayList<Integer>> result;
    
    public void doWork(int A, int B, List<Integer> temp, int currptr){
        
        if(currptr > A){
            return;
        }
        
        if(temp.size() > B)
            return;
        
        while(currptr <= A && temp.size() <= B){
            
            if(temp.size() == B){   
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int i = 0; i < temp.size(); i++){
                a.add(temp.get(i));
            }
            result.add(a);
            return;
            }
            temp.add(currptr);
            doWork(A,B,temp,currptr+1);
            temp.remove(temp.size()-1);
            currptr++;
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        if(A < B){
            return result;
        }
        
        if(A == 1)
        {
            a.add(1);
            result.add(a);
            return result;
        }
        
        doWork(A+1, B, new ArrayList<Integer>(), 1);
        return result;
    }
}
