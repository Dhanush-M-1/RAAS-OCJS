import java.util.*;

import static java.lang.Math.*;

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;

import static java.util.Arrays.*;

import java.util.Map.Entry;

public class E {
	void solve() throws Exception {
		int n = ni(), c = ni();
		int[] a = nai(n);
		int ans = Integer.MIN_VALUE;
ans = 0;
		for (int i = 1; i < a.length; i++) {
			ans = max(ans, a[i - 1] -a[i] - c);
			
		}
		out.println(ans);
	}

	static class Pair<SomeA extends Comparable<SomeA>, SomeB extends Comparable<SomeB>>
			implements Comparable<Pair<SomeA, SomeB>> {
		SomeA anA;
		SomeB aB;

		Pair(SomeA a, SomeB b) {
			this.anA = a;
			this.aB = b;
		}

		@Override
		public int compareTo(Pair<SomeA, SomeB> o) {
			int d = anA.compareTo(o.anA);
			if (d != 0)
				return aB.compareTo(o.aB);
			return d;
		}
	}

	public static void main(String[] args) throws Exception {
		E a = new E();
		a.init();
		a.solve();
		a.out.flush();
		a.out.close();
	}

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	void init() {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer("");
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
	}

	double nd() throws NumberFormatException, IOException {
		return Double.parseDouble(n());
	}

	String n() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int ni() throws NumberFormatException, IOException {
		return Integer.parseInt(n());
	}

	long nl() throws NumberFormatException, IOException {
		return Long.parseLong(n());
	}

	void rev(long[] a) {
		for (int s = 0, t = a.length - 1; s < t; s++, t--) {
			long tempLong = a[s];
			a[s] = a[t];
			a[t] = tempLong;
		}
	}

	void rev(int[] a) {
		for (int s = 0, t = a.length - 1; s < t; s++, t--) {
			int tempLong = a[s];
			a[s] = a[t];
			a[t] = tempLong;
		}
	}

	void rev(String[] a) {
		for (int s = 0, t = a.length - 1; s < t; s++, t--) {
			String tempLong = a[s];
			a[s] = a[t];
			a[t] = tempLong;
		}
	}

	void fa(int[][] d, int val) {
		for (int[] axe : d)
			Arrays.fill(axe, val);
	}

	void fa(int[][][] d, int val) {
		for (int[][] fack : d)
			fa(fack, val);
	}

	int[] nai(int n) throws Exception {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	long[] nal(int n) throws Exception {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
}
