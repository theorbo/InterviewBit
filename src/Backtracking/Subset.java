package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * https://www.interviewbit.com/problems/subset/
 * 
 * eg: [3,1,2] Output : [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
 */

public class Subset {

	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	public void doWork(ArrayList<Integer> A, int index, int limit, ArrayList<Integer> t) {

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

			result.add(a);

			doWork(A, index + 1, limit, t);
			t.remove(t.size() - 1);
			index++;

			while (index < limit && A.get(index) == A.get(index - 1)) {
				index++;
			}
		}
	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

		Collections.sort(A);

		ArrayList<Integer> t = new ArrayList<Integer>();

		result.add(t);

		doWork(A, 0, A.size(), t);

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
		

		Subset subset = new Subset();

		System.out.println(subset.subsets(list));

	}

}
