import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	final int maxn = 10000;

	int n, m;
	long a[] = new long[maxn];
	Operation operations[] = new Operation[maxn];

	boolean check() {
		long b[] = a.clone();

		for (int i = 0; i < m; i++) {
			int t = operations[i].t;
			int l = operations[i].l;
			int r = operations[i].r;
			int d = operations[i].d;
			if (t == 1)
				for (int j = l; j <= r; j++)
					b[j] += d;
			else {
				long max = b[l];
				for (int j = l + 1; j <= r; j++)
					max = max(b[j], max);
				if (max != d)
					return false;
			}
		}

		return true;
	}

	private void run() throws IOException {
		// in = new BufferedReader(new FileReader("input.txt"));
		// out = new PrintWriter("output.txt");

		if (new File("input.txt").exists())
			in = new BufferedReader(new FileReader("input.txt"));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		if (new File("output.txt").exists())
			out = new PrintWriter("output.txt");
		else
			out = new PrintWriter(System.out);

		n = nextInt();
		m = nextInt();
		fill(a, 1000 * 1000 * 1000);
		for (int i = 0; i < m; i++) {
			int t = nextInt();
			int l = nextInt() - 1;
			int r = nextInt() - 1;
			int d = nextInt();
			operations[i] = new Operation(t, l, r, d);
		}

		for (int i = 0; i < m; i++) {
			int t = operations[i].t;
			int l = operations[i].l;
			int r = operations[i].r;
			int d = operations[i].d;
			if (t == 1) {
				for (int j = l; j <= r; j++)
					a[j] = a[j] + d;
			} else {
				for (int j = l; j <= r; j++)
					a[j] = min(a[j], d);
			}
			// for (int j = 0; j < n; j++)
			// System.err.print(a[j] + " ");
			// System.err.println();
		}

		for (int i = m - 1; i >= 0; i--) {
			int t = operations[i].t;
			int l = operations[i].l;
			int r = operations[i].r;
			int d = operations[i].d;
			if (t == 1)
				for (int j = l; j <= r; j++)
					a[j] -= d;
		}

		for (int i = 0; i < n; i++)
			a[i] = min(max(a[i], -1000 * 1000 * 1000), 1000 * 1000 * 1000);

		// for (int j = 0; j < n; j++)
		// System.err.print(a[j] + " ");
		// System.err.println();

		if (check()) {
			out.println("YES");
			for (int i = 0; i < n; i++) {
				out.print(a[i] + " ");
			}
			out.println();
		} else
			out.print("NO");

		in.close();
		out.close();
	}

	class Operation {
		int t;
		int l, r, d;

		public Operation(int t, int l, int r, int d) {
			this.t = t;
			this.l = l;
			this.r = r;
			this.d = d;
		}
	}

	void chk(boolean b) {
		if (b)
			return;
		System.out.println(new Error().getStackTrace()[1]);
		exit(999);
	}

	void deb(String fmt, Object... args) {
		System.out.printf(Locale.US, fmt + "%n", args);
	}

	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}

	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
