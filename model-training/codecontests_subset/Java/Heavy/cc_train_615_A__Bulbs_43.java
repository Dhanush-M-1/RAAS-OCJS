import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bulbs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] bulbs = new int[n][];
		for (int i = 0; i < bulbs.length; i++) {
			bulbs[i] = readArray(scan);
		}
		System.out.println(solve(bulbs, m) ? "YES" : "NO");

		scan.close();
	}

	static int[] readArray(Scanner sc) {
		int size = sc.nextInt();
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static boolean solve(int[][] bulbs, int m) {
		Set<Integer> bulbSet = new HashSet<>();
		for (int i = 0; i < bulbs.length; i++) {
			for (int j = 0; j < bulbs[i].length; j++) {
				bulbSet.add(bulbs[i][j]);
			}
		}

		return bulbSet.size() == m;
	}
}