import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CT2A {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;

	static class Sort implements Comparable<Sort> {
		int ind, a;

		@Override
		public int compareTo(Sort o) {
			return a - o.a;
		}
		public Sort(int i, int an) {
			ind = i;
			a = an;
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		solve();
		pw.close();
	}
	
	static int n, k;
	static long s, t;
	static int[] c, v;
	static Integer[] g;
	
	private static void solve() throws IOException {
		n = nextInt();
		k = nextInt();
		s = nextLong();
		t = nextLong();
		c = new int [n];
		v = new int [n];
		g = new Integer[k + 2];
		for (int i = 0; i < n; ++i) {
			c[i] = nextInt();
			v[i] = nextInt();
		}
		g[0] = new Integer(0);
		g[k + 1] = new Integer((int)s);
		for (int i = 1; i <= k; ++i)
			g[i] = new Integer(nextInt());
		Arrays.sort(g);
		long vc = binsearch();
		int ans = -1, cur = -1;
		for (int i = 0; i < n; ++i) {
			if (vc <= v[i]) {
				if (ans == -1) {
					ans = i;
					cur = c[i];
				} else if (c[i] < cur) {
					cur = c[i];
					ans = i;
				}
			}
		}
		pw.println(cur);
	}

	private static long binsearch() {
		long m, l = 0, r = (long) 1e10;
		while (r - l > 1) {
			m = (r + l) / 2;
			if (check(m))
				r = m;
			else
				l = m;
		}
		return r;
	}

	private static boolean check(long vv) {
		long time = 0, dif;
		for (int i = 1; i <= k + 1; ++i) {
			dif = g[i] - g[i - 1];
			if (dif > vv)
				return false;
			if (vv >= 2 * dif)
				time += dif;
			else {
				time += vv - dif;
				time += 2 * (2 * dif - vv);
			}
		}
		return time <= t;
	}

	private static int sumf(int[] fen, int id) {
		int summ = 0;
		for (; id >= 0; id = (id & (id + 1)) - 1) 
 			summ += fen[id];
		return summ;
	}

	private static void addf(int[] fen, int id) {
		for (; id < fen.length; id |= id + 1) 
			fen[id]++;
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}