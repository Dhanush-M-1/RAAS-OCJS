import java.io.*;
import java.util.*;

public class taskA {

	void solve() throws IOException {
		int n = nextInt();
		String s = nextToken();
		
		boolean a = false;
		for (int k = 1; k <= n; k++) {
			for (int i = 0; i + 4 * k < n; i++) {
				boolean b = true;
				for (int j = i; j <= i + 4 * k; j += k) {
					b &= s.charAt(j) != '.';
				}
				a |= b;
			}
		}
		
		System.out.println(a ? "yes" : "no");
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;

	void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new taskA().run();
	}

	String nextToken() throws IOException {
		while ((st == null) || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}
}
