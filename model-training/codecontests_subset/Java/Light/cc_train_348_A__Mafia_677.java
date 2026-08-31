import java.io.*;
import java.util.*;

public class PrC {
	public static void main(String[] args) throws IOException {
		new PrC().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out, true);
		solve();
		out.flush();
	}

	void solve() throws IOException {
		int n = nextInt();
		long sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int a = nextInt();
			if (a > max) {
				max = a;
			}
			sum += a;
		}
		long res;
		if (sum % (n - 1) == 0) {
			res = sum / (n - 1);
		} else {
			res = sum / (n - 1) + 1;
		}
		if (res < max) {
			res = max;
		}
		out.println(res);
	}
}