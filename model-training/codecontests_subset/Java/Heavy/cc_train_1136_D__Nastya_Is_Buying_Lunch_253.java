import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Main implements Runnable {

	int sz[];
	int id[];
	List<Integer> edges[];
	long tree[];

	private void solve() throws IOException {
		int n = nextInt();
		int m = nextInt();
		int a[] = new int[n];
		int p[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt() - 1;
			p[a[i]] = i;
		}
		int cnt[] = new int[n];
		List<Integer> edges[] = new ArrayList[n];
		Arrays.setAll(edges, i -> new ArrayList<>());
		for (int i = 0; i < m; ++i) {
			int f = nextInt() - 1;
			int s = nextInt() - 1;
			f = p[f];
			s = p[s];
			if (s > f) {
				edges[s].add(f);
				cnt[f]++;
			}
		}
		int ans = n;
		for (int i = n - 2; i >= 0; --i) {
			if (cnt[i] + i + 1 == ans) {
				ans--;
				for (int x : edges[i]) {
					cnt[x]--;
				}
			}
		}
		pw.println(n - ans);
	}

	void test() throws IOException {
		Random rnd = new Random();
		for (int i = 0; i < 2; ++i) {
			int n = rnd.nextInt(30) + 1;
			int a[] = new int[n];
			System.err.println(n);
			for (int j = 0; j < n; ++j) {
				a[j] = rnd.nextInt(2) + 1;
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
