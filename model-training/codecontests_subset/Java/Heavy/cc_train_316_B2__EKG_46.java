import java.io.*;
import java.util.*;

public class B {

	void run() throws IOException {
		int n = ni();
		int x = ni() - 1;
		int[] a = na(n);
		int[] dsu = a.clone();
		int[] len = new int[n];
		int[] b = new int[n];
		int m = 0;

		int cur = -1;

		for (int i = 0; i < n; i++) {
			int tl = 1;
			int j = i;
			while (a[j] != 0) {
				j = a[j] - 1;
				tl++;
			}
			if (i == x) {
				cur = tl;
			}
			len[j] = Math.max(len[j], tl);
			dsu[i] = j;
		}

		Arrays.fill(b, 12345);

		for (int i = 0; i < n; i++) {
			if (a[i] == 0 && dsu[x] != i) {
				b[m++] = len[i];
			}
		}

		Arrays.sort(b);

		boolean[] u = new boolean[1001];
		u[0] = true;

		for (int i = 0; i < m; i++) {
			boolean[] v = u.clone();
			for (int j = 0; j < 1001; j++) {
				if (u[j]) {
					v[j + b[i]] = true;
				}
			}
			u = v;
		}

		for (int i = 0; i <= 1000; i++) {
			if (u[i]) {
				pw.println(i + cur);
			}
		}
		// tr("-------");

	}

	int[] na(int a_len) throws IOException {
		int[] _a = new int[a_len];
		for (int i = 0; i < a_len; i++)
			_a[i] = ni();
		return _a;
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	String nl() throws IOException {
		return br.readLine();
	}

	void tr(String debug) {
		if (!OJ)
			pw.println(" " + debug);
	}

	static PrintWriter pw;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean OJ;

	public static void main(String[] args) throws IOException {
		long timeout = System.currentTimeMillis();
		OJ = System.getProperty("ONLINE_JUDGE") != null;
		pw = new PrintWriter(System.out);
		br = new BufferedReader(OJ ? new InputStreamReader(System.in) : new FileReader(new File("B.txt")));

		while (br.ready())
			new B().run();
		if (!OJ) {
			pw.println();
			pw.println(System.currentTimeMillis() - timeout);
		}
		br.close();
		pw.close();
	}

}
