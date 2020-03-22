/* Given two words A and B, and a dictionary, C, find the length of shortest transformation sequence from A to B, such that:

You must change exactly one character in every transformation.
Each intermediate word must exist in the dictionary.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters. */

public class Solution {
    public int solve(String beginWord, String endWord, ArrayList<String> C) {
        
        Set<String> wordSet = new HashSet<>(C);
        if(!wordSet.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        int res = 0;
        while(!queue.isEmpty()){
            
            for(int i = queue.size(); i > 0  ;i--){
                
                String word = queue.poll();
                if(word.equals(endWord))
                    return res+1;
                
                for(int j = 0 ; j < word.length();j++){
                    char[] newWord = word.toCharArray();
                    
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        newWord[j] = ch;
                        String s = new String(newWord);
                        if(wordSet.contains(s) && !s.equals(word)){
                            queue.add(s);
                            wordSet.remove(s);
                        }
                    }
                }    
            }
            res++;
        }
        return 0;
    }
}
