public class RedundantBraces {
    public int braces(String A) {
     
        Stack<Character> a = new Stack<Character>();
        
        int i;
        
        for(i = 0; i < A.length();i++){
            
            char b = A.charAt(i);
            
            if(b == ')'||b == ']'||b == '}'){
                char b1 = a.peek();
                if(!(b1 == '+' || b1 == '-' || b1 == '/' || b1 == '*')){
                    return 1;
                }
                else{
                    a.pop();
                    a.pop();
                }
            }
            
            else{
                if(b == '('||b == '['||b == '{'||b == '+' || b == '-' || b == '/' || b == '*'){
                    a.push(b);
                }
            }
        }
        
        return 0;
    }
}
