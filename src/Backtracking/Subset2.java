package Backtracking;

import java.util.*;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 */

public class Subset2 {

	Set<ArrayList<Integer>> solWD = new LinkedHashSet<ArrayList<Integer>>();

	void doWork(ArrayList<Integer> A, int index, int limit, ArrayList<Integer> t) {
		if (index >= limit) {
			return;
		}

		while (index < limit) {

			t.add(A.get(index));

			/*
			 * Concept : Copy it into a new object before adding into a static object to
			 * avoid seeing same objects copied
			 */

			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int i = 0; i < t.size(); i++) {
				a.add(t.get(i));
			}

			solWD.add(a);

			doWork(A, index + 1, limit, t);
			t.remove(t.size() - 1);
			index++;
		}

	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
		
		// preProcess A
		Collections.sort(A);
		solWD.add(new ArrayList<Integer>());
		ArrayList<Integer> t = new ArrayList<Integer>();
		doWork(A, 0, A.size(), t);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> a : solWD) {
			result.add(a);
		}
		return result;
	}
	
	public static void main(String args[]) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(5);
		list.add(5);
		
		

		Subset2 subset2 = new Subset2();

		System.out.println(subset2.subsetsWithDup(list));

	}


}
