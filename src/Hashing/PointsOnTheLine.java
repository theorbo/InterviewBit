/**Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

public class PointsOnTheLine {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        
        if(a.size() == 0)
        return 0;
        
        int len = a.size();
        int max = 0;
        int i;
        
        for(i = 0; i < len; i++){
           
           int X1 = Integer.valueOf(a.get(i));
           int Y1 = Integer.valueOf(b.get(i));
           
           Map<Double,Integer> slopeMap = new HashMap<Double,Integer>();
           
           int k = 0;
         
           while(k < len){
             
               if(k != i){
                  
                  double slopePoint = slope(X1, Integer.valueOf(a.get(k)),Y1, Integer.valueOf(b.get(k)));
                 
                  if(slopeMap.containsKey(slopePoint)){
                      int count = Integer.valueOf(slopeMap.get(slopePoint));
                      count = count+1;
                      slopeMap.put(slopePoint,count);
                  }
                  else{
                      slopeMap.put(slopePoint,1);
                  }
               }
              k++;
           }
          
          max = Math.max(max, MAX(slopeMap)); 
           
        }
        
        return max+1;
    }
    
    public double slope(int X1, int X2, int Y1, int Y2){
        
        if(X2-X1 == 0){
            return Double.MAX_VALUE;
        }
      
        //Important (double) type conversion
        double value = ((double)(Y2-Y1)/(double)(X2-X1));
      
        return value;
    }
    
    public int MAX(Map<Double, Integer> slopeMap){
        int max = 0;
        
        for(Map.Entry<Double,Integer> entry : slopeMap.entrySet()){
            
            int value = Integer.valueOf(entry.getValue());
            if(value > max){
                max = value;
            }
        }
        return max;
    }
}
