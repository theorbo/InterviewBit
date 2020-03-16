/** Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.*/

//BFS solution

public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(A > B)
            return result;
            
        //bfs implementation    
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= 9; i++)
            queue.add(i);
            
        if(A == 0)
            result.add(0);
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num < B){
                int last = num%10;
                if(last > 0) queue.add(num*10+ last - 1);
                if(last < 9) queue.add(num*10 + last +1);
                
            }
            if(num>= A && num <= B)
                result.add(num);
        }    
        
        return result; 
    }
}

//Brute Force Approach

public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = A; i <= B; i++){
            if(isSteppingNumber(i))
                result.add(i);
        }
        return result;
    }
    
    public boolean isSteppingNumber(int num){
        String numString = String.valueOf(num);
        int noOfDigits = numString.length();
        char previous = numString.charAt(0);
        
        for(int i = 1; i < noOfDigits ; i++){
            char current = numString.charAt(i);
            
            if(Math.abs(current-previous) != 1)
                return false;
                
            previous = current;    
        }
        return true;
    }
}
