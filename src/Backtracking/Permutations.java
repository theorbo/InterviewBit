package Backtracking;

import java.util.ArrayList;

/**
 *Given a collection of numbers, return all possible permutations.
 */

public class Permutations {
	
ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    public void backtrack(ArrayList<Integer> A,int low, int high){
        
        if(low == high){
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int i= 0; i< A.size();i++){
            a.add(A.get(i));
           }
           
           result.add(a);
        }
        
        else{
            for(int i = low; i <= high; i++){
                A = swap(A, low, i);
                backtrack(A, low+1, high);
                A = swap(A, low, i);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        backtrack(A, 0, A.size()-1);
        return result;
        
    }
    
    public ArrayList<Integer> swap(ArrayList<Integer> A, int i, int j){
        
        int temp = Integer.valueOf(A.get(i));
        A.set(i, A.get(j));
        A.set(j, temp);
        
        return A;
    }

}
