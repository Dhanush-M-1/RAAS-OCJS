import java.util.HashSet;
import java.util.Scanner;

public class NPHardProblem {

	static boolean pos = true;

	static HashSet<Integer> red = new HashSet<Integer>();
	static HashSet<Integer> blue = new HashSet<Integer>();

	public static void dfsb(HashSet<Integer>[] adj, boolean[] vis, int v, boolean pred) {
		vis[v] = true;

		if (pred)
			blue.add(v);
		else
			red.add(v);

		for (int e : adj[v]) {
			if (!vis[e]) {
				dfsb(adj, vis, e, !pred);
			} else {
				if (red.contains(e) && red.contains(v) || blue.contains(e) && blue.contains(v)) {
					pos = false;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		HashSet<Integer>[] adj = new HashSet[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			adj[u].add(v);
			adj[v].add(u);
		}

		boolean[] vis = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (adj[i].isEmpty())
				continue;
			if (!vis[i])
				dfsb(adj, vis, i, false);

			if (!pos)
				break;

		}

		if (!pos) {
			System.out.println(-1);
		} else {

			System.out.println(blue.size());
			for (int e : blue) {
				System.out.print(e + 1 + " ");
			}
			System.out.println();

			System.out.println(red.size());
			for (int e : red) {
				System.out.print(e + 1 + " ");
			}

		}

	}

}
