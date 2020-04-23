/** How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
* /

public class Solution {
    public int fibsum(int A) {
        
        List<Integer> fibonacci = new ArrayList<>();
        
        int a = 1, b = 1, c = 0;
        fibonacci.add(a);
        
        while(c <= A){
            c = a+b;
            a = b;
            b = c;
            fibonacci.add(c);
        }
        
        int sum = A;
        int index = fibonacci.size()-1;
        int count = 0;
        
        while(sum > 0){
            
            count = count + sum/fibonacci.get(index);
            sum = sum % fibonacci.get(index);
            if(sum/fibonacci.get(index) <= 1){
               index--; 
            }
        }
        
        return count;
    }
}
