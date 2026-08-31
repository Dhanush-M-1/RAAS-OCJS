import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		ProblemD solver = new ProblemD();
		solver.solve(1, in, out);
		out.close();
	}

	static class ProblemD {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			List<Edge>[] edges = new List[n];
			for (int i = 0; i < n; i++) {
				edges[i] = new ArrayList<>();
			}
			int m = in.nextInt();
			for (int i = 0; i < m; i++) {
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				int c = in.nextInt();
				edges[a].add(new Edge(b, c));
				edges[b].add(new Edge(a, -c));
			}
			int[] x = new int[n];
			boolean[] was = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!was[i]) {
					dfs(i, edges, x, was);
				}
			}
			for (int i = 0; i < n; i++) {
				for (Edge e : edges[i]) {
					if (x[e.dst] - x[i] != e.c) {
						out.println("No");
						return;
					}
				}
			}
			out.println("Yes");
		}

		private void dfs(int i, List<Edge>[] edges, int[] x, boolean[] was) {
			was[i] = true;
			for (Edge e : edges[i]) {
				int j = e.dst;
				if (was[j]) {
					continue;
				}
				x[j] = x[i] + e.c;
				dfs(j, edges, x, was);
			}
		}

		class Edge {
			int dst;
			int c;

			Edge(int dst, int c) {
				this.dst = dst;
				this.c = c;
			}

		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String rl = in.readLine();
					if (rl == null) {
						return null;
					}
					st = new StringTokenizer(rl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}

