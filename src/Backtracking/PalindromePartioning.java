/**
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
  */
  
  public class Solution {
    
    ArrayList<ArrayList<String>> result;
    public void doWorkSubsetPalindrome(ArrayList<String> temp, String a,int currptr){
        
        if(currptr == a.length()){
            ArrayList<String> arr = new ArrayList<String>(temp);
            result.add(arr);
            return;
        }
        
        for(int i = currptr+1; i <= a.length(); i++){
            
            if(isPalindrome(a.substring(currptr, i))){
                temp.add(a.substring(currptr, i));
                doWorkSubsetPalindrome(temp,a,i);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    
    public boolean isPalindrome(String s){
        
        StringBuilder str = new StringBuilder(s);
        if(s.equals(str.reverse().toString())){
            return true;
        }
        return false;
    }
    public ArrayList<ArrayList<String>> partition(String a) {
        result = new ArrayList<ArrayList<String>>();
        
        doWorkSubsetPalindrome(new ArrayList<String>(), a, 0);
        return result;
    }
}
