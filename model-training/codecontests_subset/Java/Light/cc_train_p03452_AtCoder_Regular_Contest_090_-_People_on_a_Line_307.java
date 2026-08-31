import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static int M = 0;
	static int[] L = null;
	static int[] R = null;
	static int[] D = null;

	static ArrayList<Integer>[] LL = null;
	static ArrayList<Integer>[] RR = null;

	static boolean[] check = null;
	static long[] x = null;
	static boolean[] visited = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = new int[M];
		R = new int[M];
		D = new int[M];

		LL = new ArrayList[N + 1];
		RR = new ArrayList[N + 1];
		for (int i = 0; i < M; i++) {
			L[i] = sc.nextInt();
			R[i] = sc.nextInt();
			D[i] = sc.nextInt();

			if (LL[L[i]] == null) {
				LL[L[i]] = new ArrayList<Integer>();
			}
			LL[L[i]].add(i);
			if (RR[R[i]] == null) {
				RR[R[i]] = new ArrayList<Integer>();
			}
			RR[R[i]].add(i);
		}

		check = new boolean[M];
		Arrays.fill(check, false);
		x = new long[N + 1];
		Arrays.fill(x, 0L);
		visited = new boolean[N + 1];
		Arrays.fill(visited, false);
		boolean ans = true;
		for (int i = 0; i < M; i++) {
			if (check[i]) {
				continue;
			}
			x[L[i]] = 0L;
			x[R[i]] = D[i];
			visited[L[i]] = true;
			visited[R[i]] = true;
			check[i] = true;
			ans &= rec(i, true, true);
			if (!ans) {
				break;
			}
		}
		if (ans) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	static boolean rec(int i, boolean lcheck, boolean rcheck) {
		// Li
		if (LL[L[i]] != null && lcheck) {
			for (int j : LL[L[i]]) {
				if (check[j]) {
					continue;
				}
				check[j] = true;
				if (visited[R[j]]) {
					if (x[R[j]] - x[L[j]] != D[j]) {
						return false;
					}
				} else {
					visited[R[j]] = true;
					x[R[j]] = x[L[j]] + D[j];
					if (!rec(j, false, true)) {
						return false;
					}
				}
			}
		}
		if (RR[L[i]] != null && lcheck) {
			for (int j : RR[L[i]]) {
				if (check[j]) {
					continue;
				}
				check[j] = true;
				if (visited[L[j]]) {
					if (x[R[j]] - x[L[j]] != D[j]) {
						return false;
					}
				} else {
					visited[L[j]] = true;
					x[L[j]] = x[R[j]] - D[j];
					if (!rec(j, true, false)) {
						return false;
					}
				}
			}
		}

		// Ri
		if (LL[R[i]] != null && rcheck) {
			for (int j : LL[R[i]]) {
				if (check[j]) {
					continue;
				}
				check[j] = true;
				if (visited[R[j]]) {
					if (x[R[j]] - x[L[j]] != D[j]) {
						return false;
					}
				} else {
					visited[R[j]] = true;
					x[R[j]] = x[L[j]] + D[j];
					if (!rec(j, false, true)) {
						return false;
					}
				}
			}
		}
		if (RR[R[i]] != null && rcheck) {
			for (int j : RR[R[i]]) {
				if (check[j]) {
					continue;
				}
				check[j] = true;
				if (visited[L[j]]) {
					if (x[R[j]] - x[L[j]] != D[j]) {
						return false;
					}
				} else {
					visited[L[j]] = true;
					x[L[j]] = x[R[j]] - D[j];
					if (!rec(j, true, false)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
