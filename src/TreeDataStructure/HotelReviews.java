public class Solution {
    
    public class Sol{
        
        int pos = 0;
        long score = 0;
        
        Sol(long score, int pos){
            this.score = score;
            this.pos = pos;
        }
    }
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        
        String[] s = A.split("_");
        HashMap<String, Integer> mp =new HashMap<String, Integer>();
        
        int i,j;
        
        for(i = 0; i < s.length; i++){
            if(!mp.containsKey(s[i])){
                mp.put(s[i], 1);
            }
        }
            
        Sol sol;
        ArrayList<Sol> sols = new ArrayList<Sol>();
        ArrayList<Integer> result = new ArrayList<Integer>();
    
        for(i = 0; i < B.size(); i++){
            String[] s1 = B.get(i).split("_");
            long count = 0l;
            for(j = 0; j < s1.length; j++){
                if(mp.containsKey(s1[j])){
                    count++;
                }  
            }
            
            sol = new Sol(count,i);
            sols.add(sol);
            
        }
    
        //Sorting
        Collections.sort(sols, new Comparator<Sol>(){
            
            public int compare(Sol sol1, Sol sol2){
                long score1 = sol1.score;
                long score2 = sol2.score;
                
                if(score1 > score2){
                    return -1;
                }
                else{
                    if(score1 == score2){
                        if(sol1.pos < sol2.pos){
                            return -1;
                        }
                    }
                    return 1;
                }
            }
            });
        
        
        //Putting the results into the array.
        
        
        for(i = 0; i < sols.size(); i++){
             result.add(sols.get(i).pos);
        }
        
        return result;
    }
}
