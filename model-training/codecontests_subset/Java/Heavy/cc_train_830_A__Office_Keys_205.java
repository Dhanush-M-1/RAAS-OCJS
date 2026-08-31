import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main implements Runnable {

	long INF = (long) 1e13 + 7;

	private void solve() throws IOException {
		int n = nextInt();
		int k = nextInt();
		long p = nextLong();
		long a[] = new long[n];
		long b[] = new long[k];
		for (int i = 0; i < n; ++i)
			a[i] = nextLong();
		for (int i = 0; i < k; ++i)
			b[i] = nextLong();
		Arrays.sort(a);
		Arrays.sort(b);
		long ans = INF;
		for (int i = 0; i <= k - n; ++i) {
			long cur = 0;
			for (int j = 0; j < n; ++j) {
				cur = Math.max(Math.abs(a[j] - b[i + j]) + Math.abs(b[i + j] - p), cur);
			}
			ans = Math.min(cur, ans);
		}
		pw.println(ans);
	}

	void test() throws IOException {
		Random rnd = new Random();
		for (int i = 0; i < 5; ++i) {
			int n = rnd.nextInt(10) + 1;
			int a[] = new int[n];
			System.err.println(n);
			for (int j = 0; j < n; ++j) {
				a[j] = rnd.nextInt(20) + 1;
				System.err.print(a[j] + " ");
			}
//			solve(n, a);
			System.err.println();
		}
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter pw;

	public static void main(String args[]) {
		new Main().run();
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in), 32768);
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
