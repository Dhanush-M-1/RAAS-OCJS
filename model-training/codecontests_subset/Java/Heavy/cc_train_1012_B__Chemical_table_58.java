import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class D1013 {
	static class DisjointSet {
		int[] rank;
		int[] parent;

		DisjointSet(int n) {
			rank = new int[n];
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = i;
			}
		}

		int find(int n) {
			if (parent[n] == n) return n;

			int ret = find(parent[n]);
			parent[n] = ret;
			return ret;
		}

		boolean union(int a, int b) {
			a = find(a);
			b = find(b);
			if (a == b) return false;
			if (rank[a] == rank[b]) {
				parent[a] = b;
				rank[b]++;
			} else if (rank[a] < rank[b]) {
				parent[a] = b;
			} else {
				parent[b] = a;
			}
			return true;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream out = new PrintStream(new BufferedOutputStream(System.out));

		int N = in.nextInt(), M = in.nextInt(), Q = in.nextInt();

		DisjointSet dsu = new DisjointSet(N + M);
		int ans = N + M - 1;
		for (int i = 0; i < Q; i++) {
			int x = in.nextInt() - 1, y = in.nextInt() - 1;

			if (dsu.union(x, N + y)) ans--;
		}
		out.println(ans);

		in.close();
		out.close();
	}
}
