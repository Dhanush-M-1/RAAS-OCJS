import java.io.*;
import java.util.*;

public class c {

	public void solve() throws IOException {
		int n = nextInt();
		int m = nextInt();
		int w[] = new int[n];
		int b[] = new int[m];
		for (int i = 0; i < n; i++) {
			w[i] = nextInt();
		}
		for (int i = 0; i < m; i++) {
			b[i] = nextInt() - 1;
		}
		LinkedList<Integer> ord = new LinkedList<Integer>();
		HashSet<Integer> q = new HashSet<Integer>();

		for (int i = 0; i < m; i++) {
			int book = b[i];
			if (!q.contains(book)) {
				q.add(book);
				ord.add(book);
			}
		}
		long ans = 0;
		for (int i = 0; i < m; i++) {
			int j = 0;
			while (ord.get(j) != b[i]) {
				ans += w[ord.get(j)];
				j++;
			}
			int up = ord.get(j);
			ord.remove(j);
			ord.addFirst(up);
		}
		out.print(ans);
	}

	public void run() throws IOException {

		// br = new BufferedReader(new FileReader(new File("")));
		// out = new PrintWriter("");
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();

		br.close();
		out.close();

	}

	public static void main(String[] args) throws IOException {
		new c().run();
	}

	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		return (int) (a * b / gcd(a, b));
	}

}