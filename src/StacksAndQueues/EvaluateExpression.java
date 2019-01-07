public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < A.size(); i++){
            String s = A.get(i);
            
            if(s.equals("+")){
                int n2 = Integer.valueOf(stack.pop()); 
                int n1 = Integer.valueOf(stack.pop()); 
                
                stack.push(n1+n2);
            }
            else if(s.equals("-")){
                int n2 = Integer.valueOf(stack.pop()); 
                int n1 = Integer.valueOf(stack.pop()); 
                
                stack.push(n1-n2);
            }
            else if(s.equals("*")){
                int n2 = Integer.valueOf(stack.pop()); 
                int n1 = Integer.valueOf(stack.pop()); 
                
                stack.push(n1*n2);
            }
            else if(s.equals("/")){
                int n2 = Integer.valueOf(stack.pop()); 
                int n1 = Integer.valueOf(stack.pop()); 
                
                stack.push(n1/n2);
            }
            else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
