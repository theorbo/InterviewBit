public class Solution {
  public int searchInsert(ArrayList<Integer> a, int b) {

    return binarySearch(a,b,0,a.size()-1);
  }

  public int binarySearch(ArrayList<Integer> a, int b, int low, int high){

    int mid;
    int pos = -1;

    while(low <= high){
      mid = (low+high)/2;

      if(Integer.valueOf(a.get(mid)) == b){
        return mid;
      }
      else if(Integer.valueOf(a.get(mid)) < b){
        pos = mid;
        low = mid+1;
      }
      else{
        high = mid-1;
      }
    }
    return pos+1;
  }
}
