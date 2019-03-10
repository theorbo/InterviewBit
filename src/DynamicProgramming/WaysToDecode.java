public class Solution {
    
    int[] dp;
    
    public boolean isPossible2(char a, char b){
        
        if(a == '1'){
            return true;
        }
        else if(a== '2' && b <= '6'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isPossible1(char a){
        
        if(a != '0'){
            return true;
        }
        return false;
    }
    public int countDecoding(int pos, String A){
    
    if(dp[pos] != -1){
        return dp[pos];
    }
    
    if(pos == 0){
        if(isPossible1(A.charAt(0)))
            dp[pos] = 1;
        else
            dp[pos] = 0;
         return dp[pos];  
    }
        
    
    
    if(pos == 1){
       
       if(isPossible1(A.charAt(pos))){
           if(isPossible2(A.charAt(0), A.charAt(1))){
               dp[pos] = countDecoding(0,A) + 1;
           }
           else{
               dp[pos] = countDecoding(0,A);
           }
       }
       else if(isPossible2(A.charAt(0), A.charAt(1))){
           dp[pos] = countDecoding(0,A);
       }
       
       else{
           dp[pos] = 0;
       }
    }
    
    else{
        
        if(isPossible1(A.charAt(pos))){
           if(isPossible2(A.charAt(pos-1), A.charAt(pos))){
               dp[pos] = countDecoding(pos-1,A) + countDecoding(pos-2,A);
           }
           else{
               dp[pos] = countDecoding(pos-1,A);
           }
       }
       else if(isPossible2(A.charAt(pos-1), A.charAt(pos))){
           dp[pos] = countDecoding(pos-2,A);
       }
       
       else{
           dp[pos] = 0;
       }
       
    }
    
    return dp[pos];
        
}
    public int numDecodings(String A) {
        
        A.toUpperCase();
        
        dp = new int[A.length()];
        
        for(int i = 0; i < A.length(); i++){
            dp[i] = -1;
        }
        
        return countDecoding(A.length()-1, A);
        
    }
}
