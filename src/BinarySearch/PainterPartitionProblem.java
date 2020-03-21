/* Given 2 integers A and B and an array of integars C of size N.
Element C[i] represents length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.
Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
*/

public class Solution {
    
    long MOD = 10000003;
    
    public int isPossible(ArrayList<Integer> boards, long noOfPainters, long singleUnitLength){
        int i = 0, count = 1;
        long temp = 0l;
        for(i = 0; i < boards.size(); i++){
            
            if((long)boards.get(i) + temp <= singleUnitLength){
                temp += boards.get(i);
            }
            else{
                count++;
                if(count > noOfPainters)
                    return -1;
                temp = (long)boards.get(i);    
            }
        }
        return 1;
    }
    public int paint(int A, int B, ArrayList<Integer> C) {
        
        long low = findMAX(C);
        long high = findTotal(C);
        long value = ((binarySearch(C, low, high, A)%MOD)*(B%MOD))%MOD;
        return (int)(value);
        
    }
    
    public long binarySearch(ArrayList<Integer> boards, long low, long high, int noOfPainters){
        
        long mid = 0, ans = 0;
        
        while(low <= high){
             mid = low + (high-low)/2;
             
             int value = isPossible(boards, noOfPainters, mid);
             if(value == 1){
                 ans = mid;
                 high = mid -1;
             }
             else {
                 low = mid+1;
             }
        }
        
        return ans;
        
    }
    
    public long findMAX(ArrayList<Integer> boards){
        
        long max = Long.MIN_VALUE;
        for(int i = 0; i < boards.size(); i++){
            if((long)boards.get(i) > max)
                max = boards.get(i);
        }
        return max;
    }
    
    public long findTotal(ArrayList<Integer> boards){
        
        long sum = 0;
        for(int i = 0; i < boards.size(); i++){
            sum += boards.get(i);
        }
        return sum;
    }
}
