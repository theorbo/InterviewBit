public class HighestProduct {
    public int maxp3(ArrayList<Integer> A) {
        
        Collections.sort(A);
        
        int len = A.size();
        
        int maximum1 = A.get(0)*A.get(1)*A.get(len-1); 
        int maximum2 = A.get(len-1)*A.get(len-2)*A.get(len-3);
        
        
        return Math.max(maximum1, maximum2);
    }
}
