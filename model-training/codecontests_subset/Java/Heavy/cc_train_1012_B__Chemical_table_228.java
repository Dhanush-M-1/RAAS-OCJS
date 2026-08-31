
/*
 * If a number of rows have an intersection, then we can have the union of their cells,
 * we need numsets-1 additional cells to union them together then cover columns that were not covered before
 */
import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();

		int[] last = new int[m];
		Arrays.fill(last, -1);

		DSU dsu = new DSU(n);
		int ans = m;
		while (q-- > 0) {
			int r = sc.nextInt() - 1, c = sc.nextInt() - 1;
			if (last[c] != -1)
				dsu.union(last[c], r);
			else
				ans--;
			last[c] = r;

		}

		ans += dsu.numSets - 1;
		out.println(ans);
		out.close();

	}

	static class DSU {
		int[] p, r;
		int numSets;

		DSU(int n) {
			p = new int[n];
			r = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
			numSets = n;
		}

		boolean union(int x, int y) {
			x = findSet(x);
			y = findSet(y);
			if (x == y)
				return false;
			if (r[x] > r[y]) {
				p[y] = x;
			} else {
				p[x] = y;
				if (r[x] == r[y])
					r[y]++;
			}
			numSets--;
			return true;

		}

		int findSet(int x) {
			if (p[x] == x)
				return x;
			else
				return p[x] = findSet(p[x]);
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

}