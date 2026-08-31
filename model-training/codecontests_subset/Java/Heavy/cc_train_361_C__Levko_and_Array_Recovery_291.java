import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {

	void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] query = new int[m][4];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < 4; j++)
				query[i][j] = sc.nextInt();

		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int s = 0;
			int mi = (int)1e9;
			for (int[] q : query) {
				if (q[0] == 1 && q[1] <= i && i <= q[2]) s += q[3];
				if (q[0] == 2 && q[1] <= i && i <= q[2]) {
					mi = min(mi, (q[3] - s));
				}
			}
			a[i] = mi;
		}

		if (check(a.clone(), query)) {
			out.println("YES");
			print(Arrays.copyOfRange(a, 1, a.length));
		} else {
			out.println("NO");
		}

	}


	boolean check(int[] a, int[][] query) {
		int n = a.length - 1;
		int m = query.length;

		int[] mas = new int[m];
		for (int i = 0; i < m; i++) mas[i] = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				int[] q = query[j];
				if (q[0] == 1 && q[1] <= i && i <= q[2]) a[i] += q[3];
				if (q[0] == 2 && q[1] <= i && i <= q[2]) {
					mas[j] = max(mas[j], a[i]);
				}
			}
		}

		for (int j = 0; j < m; j++) {
			int[] q = query[j];
			if (q[0] == 2) {
				if (mas[j] != q[3])
					return false;
			}
		}
		return true;
	}


	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	static void tr(Object... os) {
		System.err.println(deepToString(os));
	}
	static void fill(int[][] a, int val) {
		for(int i = 0; i < a.length; i++) Arrays.fill(a[i], val);
	}
	static void fill(int[][][] a, int val) {
		for(int i = 0; i < a.length; i++) fill(a[i], val);
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new MyScanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public String next() {
			eat();
			return tokenizer.nextToken();
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
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
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}
