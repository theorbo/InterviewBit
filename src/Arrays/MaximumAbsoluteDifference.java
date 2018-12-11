package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumAbsoluteDifference {

  class Node{

    int value;
    int index;
    int addValue;
    int subValue;

    Node(int value, int index, int addValue, int subValue){
      this.value = value;
      this.index = index;
      this.addValue = addValue;
      this.subValue = subValue;
    }
  }
  public int maxArr(ArrayList<Integer> A) {
    int i;
    List<Node> nodes = new ArrayList<Node>();

    for(i = 0; i < A.size(); i++){
      int val = Integer.valueOf(A.get(i));
      nodes.add(new Node(val, i, val+i, val - i));
    }

    Collections.sort(nodes, new Comparator<Node>(){
      public int compare(Node a, Node b){

        if(a.addValue < b.addValue)
          return -1;
        else if(a.addValue == b.addValue)
          return 0;
        else
          return 1;
      }
    });

    int len = nodes.size();
    int addmin = nodes.get(0).addValue;
    int addmax = nodes.get(len-1).addValue;

    Collections.sort(nodes, new Comparator<Node>(){
      public int compare(Node a, Node b){

        if(a.subValue < b.subValue)
          return -1;
        else if(a.subValue == b.subValue)
          return 0;
        else
          return 1;
      }
    });

    int submin = nodes.get(0).subValue;
    int submax = nodes.get(len-1).subValue;

    return Math.max(addmax - addmin, submax - submin);

  }

  public static void main(String args[]){

    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(1);
    list.add(3);
    list.add(-1);

    MaximumAbsoluteDifference maximumAbsoluteDifference = new MaximumAbsoluteDifference();

    System.out.println(maximumAbsoluteDifference.maxArr(list));

  }

}
