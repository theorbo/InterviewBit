/* Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.*/

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        
        int pos = -1;
        for(int i = 0 ;i < A.size(); i++){
            
            if(A.get(i).get(A.get(i).size() -1) == B){
                return 1;
            }
            else if(A.get(i).get(A.get(i).size() -1) > B){
                pos = binary_search(A.get(i), 0, A.get(i).size()-1, B);
                break;
            }
        }
        return pos != -1 ? 1:0;
    }
    
    public int binary_search(ArrayList<Integer> a, int low , int high, int num){
        
        int mid = 0;
        while(low <= high){
            
            mid = (low+high)/2;
            
            if(a.get(mid) == num)
                return mid;
            
            else if(a.get(mid) < num)
                low = mid+1;
            
            else
                high = mid-1;
        }
        
        return -1;
    }
}
