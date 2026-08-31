import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main implements Runnable {

	int INF = (int) 1e9 + 7;
	List<Integer> edges[];
	int anc[][];
	boolean vis[][];

	static class Pair {
		int a;
		int b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	private void solve() throws IOException {
		int t = nextInt();
		for (int tt = 0; tt < t; ++tt) {
			int n = nextInt();
			char a[][] = new char[n][n];
			for (int i = 0; i < n; ++i) {
				a[i] = next().toCharArray();
			}
			List<Pair> ans = new ArrayList<>();
			if (a[1][0] == a[0][1]) {
				if (a[1][0] == '1') {
					if (a[n - 1][n - 2] == '0') {

					} else {
						a[n - 1][n - 2] = '0';
						ans.add(new Pair(n, n - 1));
					}
					if (a[n - 2][n - 1] == '0') {

					} else {
						a[n - 2][n - 1] = '0';
						ans.add(new Pair(n - 1, n));
					}
				} else {
					if (a[n - 1][n - 2] == '1') {

					} else {
						a[n - 1][n - 2] = '1';
						ans.add(new Pair(n, n - 1));
					}
					if (a[n - 2][n - 1] == '1') {

					} else {
						a[n - 2][n - 1] = '1';
						ans.add(new Pair(n - 1, n));
					}
				}
			}
			if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
				if (a[n - 1][n - 2] == '1') {
					if (a[0][1] == '0') {

					} else {
						a[0][1] = '0';
						ans.add(new Pair(1, 2));
					}
					if (a[1][0] == '0') {

					} else {
						a[1][0] = '0';
						ans.add(new Pair(2, 1));
					}
				} else {
					if (a[0][1] == '1') {

					} else {
						a[0][1] = '1';
						ans.add(new Pair(1, 2));
					}
					if (a[1][0] == '1') {

					} else {
						a[1][0] = '1';
						ans.add(new Pair(2, 1));
					}
				}
			}
			if (a[0][1] != a[1][0]) {
				if (a[0][1] == '1') {
					a[1][0] = '1';
					ans.add(new Pair(2, 1));
				} else {
					a[0][1] = '1';
					ans.add(new Pair(1, 2));
				}
				if (a[n - 1][n - 2] == '1') {
					ans.add(new Pair(n, n - 1));
				}
				if (a[n - 2][n - 1] == '1') {
					ans.add(new Pair(n - 1, n));
				}
			}
			if (ans.size() > 2)
				throw new AssertionError();
			pw.println(ans.size());
			for (Pair p : ans) {
				pw.print(p.a + " " + p.b);
				pw.println();
			}

		}
	}

	long gcd(long a, long b) {
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter pw;

	public static void main(String args[]) {
		new Main().run();
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(System.out);
			st = null;
			solve();
			pw.flush();
			pw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
}
