public class Solution {
    public int colorful(int A) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        String num = String.valueOf(A);
        int i, j;
        
        for(i = 1; i <= num.length(); i++){
            
            for(j = 0; j < num.length(); j++){
                
                if(i+j <= num.length()){
                    
                int key = Integer.valueOf(num.substring(j, i+j));
                
                int mapKey = MapKey(key);
                
                if(map.containsKey(mapKey)){
                    return 0;
                }
                else{
                    map.put(mapKey,1);
                }
                
                }
            }
        }
        
        return 1;
    }
    
    public int MapKey(int key){
        
        int value = 1, r = 0;
        
        while(key > 0){
            r = key%10;
            value = value* r;
            key = key/10;
        }
        
        return value;
    }
}

