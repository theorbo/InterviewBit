package Backtracking;

import java.util.*;

public class NQueens {

	public class QueenPosition {
		int row;
		int column;

		public QueenPosition(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();



	private ArrayList<String> printNQueens(ArrayList<QueenPosition> queenPositions, int a) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < a; i++) {
			StringBuffer s = new StringBuffer();
			for (int j = 0; j < a; j++) {
				s = s.append(".");
			}
			result.add(s.toString());
		}

		for (int i = 0; i < queenPositions.size(); i++) {
			int row = queenPositions.get(i).row;
			int column = queenPositions.get(i).column;

			String s = result.get(i);
			StringBuffer str = new StringBuffer(s);
			str.replace(column, column + 1, "Q");
			result.set(row, str.toString());
		}

		return result;
	}
	
	public void doWork(ArrayList<QueenPosition> queenPositions, int X, int Y, int count, int a) {
		
		if(!isSafe(queenPositions, X, Y, a)) {
			return;
		}
		else {
			
			QueenPosition queenPosition = new QueenPosition(X,Y);
			queenPositions.add(queenPosition);
			count++;
			
			if(count == a) {
				output.add(printNQueens(queenPositions,a));
			}
			else {
				
				for(int i = 0; i < a; i++) {
					doWork(queenPositions,X+1,i,count,a);
				}
			}
			queenPositions.remove(queenPositions.size() - 1);
			
		}
	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		
		ArrayList<QueenPosition> queenPositions = new ArrayList<QueenPosition>();
		
		for(int i = 0; i < a;i++) {
			doWork(queenPositions,0,i,0,a);
		}
		return output;

	}

	public boolean isSafe(ArrayList<QueenPosition> queenPositions, int currentX, int currentY, int a) {
		if(currentX >= a) {
			return false;
		}
		for (int i = 0; i < queenPositions.size(); i++) {

			int dangerX = Integer.valueOf(queenPositions.get(i).row);
			int dangerY = Integer.valueOf(queenPositions.get(i).column);

			if (currentX == dangerX) {
				return false;
			} else if (currentY == dangerY) {
				return false;
			} else if ((currentX - currentY) == (dangerX - dangerY)) {
				return false;
			} else if ((currentX + currentY) == (dangerX + dangerY)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {

		NQueens nQueens = new NQueens();
		System.out.println(nQueens.solveNQueens(4));
	}

}
