
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Codeforces Problem 1334D
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);) {
			int t = scanner.nextInt();
			for (int i = 0; i < t; i++) {
				String solution = solveNext(scanner);
				System.out.println(solution);
			}
		}
		System.exit(0);
	}

	public static String solveNext(Scanner scanner) {
		int num = scanner.nextInt();
		long left = scanner.nextLong();
		long right = scanner.nextLong();
		return new Solution(num, left, right).solve();
	}

	int num;
	long left;
	long right;

	public Solution(int num, long left, long right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}

	public String solve() {
		List<Integer> vertices = new LinkedList<>();
		long currEdge = 1;
		for (int i = 1; i < this.num; i++) {
			long nextCutoff = currEdge + 2 * (this.num - i);
			if (this.left > nextCutoff) {
				currEdge = nextCutoff;
				continue;
			}

			if (currEdge > this.right) {
				break;
			}

			for (int j = i + 1; j <= this.num; j++) {
				if (currEdge >= this.left && currEdge <= this.right) {
					vertices.add(i);
				}
				currEdge++;
				if (currEdge >= this.left && currEdge <= this.right) {
					vertices.add(j);
				}
				currEdge++;
			}
		}

		if (currEdge <= this.right) {
			vertices.add(1);
		}

		StringBuilder sb = new StringBuilder();
		for (Integer vertex : vertices) {
			sb.append(vertex).append(" ");
		}

		return sb.toString();
	}

}
