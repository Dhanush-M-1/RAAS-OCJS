import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B284 {
	FastScanner in;
	PrintWriter out;

	public void solve() throws IOException {
		int a = 0, f = 0, q = 0;
		int n = in.nextInt();
		String s = in.next();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'F') {
				f++;
			} else if (s.charAt(i) == 'A') {
				a++;
			} else {
				q++;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'F') {
				continue;
			} else if (s.charAt(i) == 'A') {
				if (q == 0) {
					ans++;
				}
			} else { 
				if (q == 1) {
					ans++;
				}
			}
		}
		out.println(ans);
	}

	public void run() {
		try {
			InputStream inputStream = System.in;
			in = new FastScanner(inputStream);
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		public boolean hasNext() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = br.readLine();
					if (line == null) {
						return false;
					}
					st = new StringTokenizer(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (st != null && st.hasMoreTokens()) {
				return true;
			}
			return false;
		}

		public String next() {
			if (hasNext()) {
				return st.nextToken();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		new B284().run();
	}
}