

import java.util.Scanner;

public class Woodcutters {

	private static class Tree {

		private final int x;

		private final int height;

		public Tree(int x, int height) {
			this.x = x;
			this.height = height;
		}

		public int leftCut() {
			return x - height;
		}

		public int rightCut() {
			return x + height;
		}

		public int getX() {
			return x;
		}

	}

	/**
	 * Test cases:
	 * 
	 * 5 1 2 2 1 5 10 10 9 19 1 -> 3
	 * 
	 * 5 1 2 2 1 5 10 10 9 20 1 -> 4
	 */
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int numTrees = s.nextInt();
			Tree[] trees = new Tree[numTrees];
			for (int i = 0; i < numTrees; i++) {
				int x = s.nextInt();
				int height = s.nextInt();
				trees[i] = new Tree(x, height);
			}
			int countCut = 0;
			// Store how far we can cut to the left.
			int leftBarrier = Integer.MIN_VALUE;
			for (int i = 0; i < numTrees; i++) {
				int leftCut = trees[i].leftCut();
				int rightCut = trees[i].rightCut();
				if (leftCut > leftBarrier) {
					// We can cut to the left.
					leftBarrier = trees[i].getX();
					countCut++;
				} else if (i == numTrees - 1 || rightCut < trees[i + 1].getX()) {
					// We can cut to the right.
					leftBarrier = rightCut;
					countCut++;
				} else {
					// Skip cutting this tree.
					leftBarrier = trees[i].getX();
				}
			}
			System.out.println(countCut);
		}
	}

}
