import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskC {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int q = in.nextInt();
			CappingTree ta = new CappingTree(n + k, a);
			CappingTree tb = new CappingTree(n + k, b);
			for (int qid = 0; qid < q; qid++) {
				int type = in.nextInt();
				if (type == 1) {
					int pos = in.nextInt() - 1;
					int val = in.nextInt();
					ta.add(pos, val);
					tb.add(pos, val);
				} else {
					int pos = in.nextInt() - 1;
					out.println(tb.sum(0, pos - 1) + ta.sum(pos + k, n + k - 1));
				}
			}
		}

		class CappingTree {
			int[] a;
			int[] s;
			int cap;

			CappingTree(int n, int cap) {
				a = new int[n];
				s = new int[n];
				this.cap = cap;
			}

			void add(int pos, int val) {
				int na = Math.min(a[pos] + val, cap);
				add1(pos, na - a[pos]);
				a[pos] = na;
			}

			private void add1(int pos, int val) {
				while (pos < s.length) {
					s[pos] += val;
					pos |= pos + 1;
				}
			}

			int sum(int l, int r) {
				if (l > r) {
					return 0;
				}
				return sum(r) - sum(l - 1);
			}

			int sum(int r) {
				int res = 0;
				while (r >= 0) {
					res += s[r];
					r = (r & (r + 1)) - 1;
				}
				return res;
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

