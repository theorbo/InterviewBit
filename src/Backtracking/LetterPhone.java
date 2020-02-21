/**
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    
    ArrayList<String> result; 
    public void doWork(String A, ArrayList<String> temp, Map<String, String[]> lp, int index, int limit){
        
        if(index > limit)
            return;
        
        if(index ==  limit){
            StringBuilder str=new StringBuilder();
            //Important to put A.length() and not temp.length
            for(int i = 0; i < A.length(); i++){
                str.append(temp.get(i));
            }    
            result.add(str.toString());
            return;
        }  
        
        String[] s1 = lp.get(String.valueOf(A.charAt(index)));
        for(int i = 0 ;i < s1.length; i++){
            temp.add(index,s1[i]);
            doWork(A,temp,lp,index+1,limit);
        }
    }
    public ArrayList<String> letterCombinations(String A) {
        result = new ArrayList<>();
        Map<String, String[]> lp = new HashMap<String, String[]>();
        lp.put("0", new String[]{"0"});
        lp.put("1", new String[]{"1"});
        lp.put("2", new String[]{"a","b","c"});
        lp.put("3", new String[]{"d","e","f"});
        lp.put("4", new String[]{"g","h","i"});
        lp.put("5", new String[]{"j","k","l"});
        lp.put("6", new String[]{"m","n","o"});
        lp.put("7", new String[]{"p","q","r","s"});
        lp.put("8", new String[]{"t","u","v"});
        lp.put("9", new String[]{"w","x","y","z"});
        
        
        doWork(A, new ArrayList<String>(A.length()), lp, 0, A.length());
        return result;
        
    }
}
