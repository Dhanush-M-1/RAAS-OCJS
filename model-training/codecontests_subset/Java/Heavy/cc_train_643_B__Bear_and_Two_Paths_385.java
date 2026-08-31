import java.util.*;
import java.io.*;

public class B {
	FastScanner in;
	PrintWriter out;

	public void solve() throws IOException {
		int n = in.nextInt(), k = in.nextInt();
		if (n == 4 || k <= n) {
			out.println(-1);
			return;
		}
		ArrayList<Integer> vs = new ArrayList<>();
		int a = in.nextInt() - 1, b = in.nextInt() - 1, c = in.nextInt() - 1, d = in.nextInt() - 1;
		int e = -1;
		for (int i = 0; i < n; i++) {
			if (i != a && i != b && i != c && i != d) {
				if (e == -1) {
					e = i;
				} else {
					vs.add(i);
				}
			}
		}
		ArrayList<Integer> ab = new ArrayList<>(), cd = new ArrayList<>();
		ab.add(a);
		ab.add(c);
		ab.add(e);
		ab.add(d);
		for (int x : vs) {
			ab.add(x);
		}
		ab.add(b);
		
		cd.add(c);
		cd.add(a);
		cd.add(e);
		cd.add(b);
		for (int i = vs.size() - 1; i >= 0; i--) {
			cd.add(vs.get(i));
		}
		cd.add(d);
		for (int x : ab) {
			out.print((x + 1) + " ");
		}
		out.println();
		for (int x : cd) {
			out.print((x + 1) + " ");
		}
		out.println();
	}

	public void run() {
		try {
			in = new FastScanner();
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] arg) {
		new B().run();
	}
}