/** Given a 3 x A board, find the number of ways to color it using at most 4 colors such that no 2 adjacent boxes have same color.
Diagonal neighbors are not treated as adjacent boxes.
Return the ways modulo 109 + 7 as the answer grows quickly.

Suggestion : Refer : https://www.geeksforgeeks.org/ways-color-3n-board-using-4-colors/

*/

public class Solution {
    
    public int solve(int A) {
        long color3 = 24; // When we to fill single column 
        long color2 = 12; 
        long temp = 0; 
        for (int i = 2; i <= A; i++)         
        { 
            temp = color3; 
            color3 = (11 * color3 + 10 * color2 ) % 1000000007; 
            color2 = ( 5 * temp + 7 * color2 ) % 1000000007; 
        } 
        long num = (color3 + color2) % 1000000007; 
        return (int)num; 
    }
}
