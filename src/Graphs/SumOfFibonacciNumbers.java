/** How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
* /

public class Solution {
    public int fibsum(int A) {
        
        List<Integer> fibonacci = new ArrayList<>();
        
        int a = 1, b = 1, c = 0;
        fibonacci.add(a);
        while(c <= A){
            c = a + b;
            a = b;
            b = c;
            fibonacci.add(c);
        }
        
        int count = 0;
        int index = fibonacci.size()-1;

        while(A > 0){
          count += A/fibonacci.get(index);
          A = A % fibonacci.get(index);
          index--;
        }
        
        return count;
    }
}
