import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	static void solve() throws Exception {
		long n = sc.nextLong(), l = sc.nextLong(), r = sc.nextLong(), cur = 0;
		for (long i = 1; i <= n && cur < r; i++) {
			long len = (n - i) * 2;
			if (cur + len < l) {
				cur += len;
			} else {
				for (long j = i + 1; j <= n; j++) {
					if (++cur >= l && cur <= r) out.print(i + " ");
					if (++cur >= l && cur <= r) out.print(j + " ");
				}
			}
		}
		if (r == n * (n - 1) + 1) out.print(1);
		out.println();
	}

	public static void main(String[] args) throws Exception {
		int tc = sc.nextInt();
		while (tc-- > 0) {
			solve();
		}
		out.close();
	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream system) {
		br = new BufferedReader(new InputStreamReader(system));
	}

	public Scanner(String file) throws Exception {
		br = new BufferedReader(new FileReader(file));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public Long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}
