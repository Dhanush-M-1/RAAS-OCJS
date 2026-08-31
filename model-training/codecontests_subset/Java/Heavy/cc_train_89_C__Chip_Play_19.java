import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution implements Runnable {

	public static void main(String[] args) {
		(new Thread(null, new Solution(), "1", (1l << 28))).start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String r = in.readLine();
			if (r == null) return null;
			st = new StringTokenizer(r);
		}
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
	
	char[][] a;
	int[][] sl, su, sd, sr;
	int[][] tsl, tsu, tsd, tsr;
	int n, m;
	boolean[][] ww;
	
	int gettl(int x, int y) {
		if (y == -1) return -1;
		if (!ww[x][y]) {
			return y;
		}
		return tsl[x][y] = gettl(x, tsl[x][y]);
	}
	
	int gettr(int x, int y) {
		if (y == -1) return -1;
		if (!ww[x][y]) {
			return y;
		}
		return tsr[x][y] = gettr(x, tsr[x][y]);
	}
	
	int gettu(int x, int y) {
		if (x == -1) return -1;
		if (!ww[x][y]) {
			return x;
		}
		return tsu[x][y] = gettu(tsu[x][y], y);
	}
	
	int gettd(int x, int y) {
		if (x == -1) return -1;
		if (!ww[x][y]) {
			return x;
		}
		return tsd[x][y] = gettd(tsd[x][y], y);
	}
	
	int f(int q, int w) {
		int res = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tsl[i][j] = sl[i][j];
				tsr[i][j] = sr[i][j];
				tsu[i][j] = su[i][j];
				tsd[i][j] = sd[i][j];
			}
		}
		ww = new boolean[n][m];
		ww[q][w] = true;
		while (q != -1 && w != -1) {
			switch (a[q][w]) {
			case 'L':
				w = gettl(q, w);
				if (w == -1) return res;
				break;
			case 'R':
				w = gettr(q, w);
				if (w == -1) return res;
				break;
			case 'U':
				q = gettu(q, w);
				if (q == -1) return res;
				break;
			case 'D':
				q = gettd(q, w);
				if (q == -1) return res;
				break;
			}
			ww[q][w] = true;
			res++;
		}
		out.println(q + " " + w + " " + res);
		out.flush();
		return res;
	}

	void solve() throws Exception {
		n = nextInt();
		m = nextInt();
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = nextToken();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j);
			}
		}
		sl = new int[n][m];
		for (int i = 0; i < n; i++) sl[i][0] = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a[i][j - 1] != '.') sl[i][j] = j - 1; else sl[i][j] = sl[i][j - 1];
			}
		}
		sr = new int[n][m];
		for (int i = 0; i < n; i++) sr[i][m - 1] = -1;
		for (int i = 0; i < n; i++) {
			for (int j = m - 2; j >= 0; j--) {
				if (a[i][j + 1] != '.') sr[i][j] = j + 1; else sr[i][j] = sr[i][j + 1];
			}
		}
		su = new int[n][m];
		for (int i = 0; i < m; i++) su[0][i] = -1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i - 1][j] != '.') su[i][j] = i - 1; else su[i][j] = su[i - 1][j];
			}
		}
		sd = new int[n][m];
		for (int i = 0; i < m; i++) sd[n - 1][i] = -1;
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (a[i + 1][j] != '.') sd[i][j] = i + 1; else sd[i][j] = sd[i + 1][j];
			}
		}
		tsl = new int[n][m];
		tsr = new int[n][m];
		tsu = new int[n][m];
		tsd = new int[n][m];
		int ans = -1;
		int ansc = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != '.') {
					int tmp = f(i, j);
					if (tmp > ans) {
						ans = tmp;
						ansc = 1;
					} else if (tmp == ans) ansc++;
				}
			}
		}
		out.println(ans + " " + ansc);
	}

	public void run() {
		Locale.setDefault(Locale.UK);
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
//			in = new BufferedReader(new FileReader("input.txt"));
//			out = new PrintWriter("output.txt");
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.flush();
		}
	}

}
