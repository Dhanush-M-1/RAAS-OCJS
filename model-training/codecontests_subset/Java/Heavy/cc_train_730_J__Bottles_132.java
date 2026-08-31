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



public class ACM1J {

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
	
	static int n;
	static int[] a, b, sa;
	static int[][] d;
	static int k, t, sum = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		n = nextInt();
		a = new int [n];
		b = new int [n];
		sa = new int [n];
		for (int i = 0; i < n; ++i) {
			b[i] = nextInt();
			sum += b[i];
		}
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
			sa[i] = -a[i];
		}
		Arrays.sort(sa);
		int sumk = 0;
		for (int i = 0; i < n; ++i) {
			sumk -= sa[i];
			if (sumk >= sum) {
				k = i + 1;
				break;
			}
		}
		int max = k * 100;
		d = new int [k + 1][max + 1];
		for (int i = 0; i <= k; ++i)
			Arrays.fill(d[i], -1);
		d[0][0] = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = k; j > 0; --j) {
				for (int m = max; m > 0; --m) {
					if (m - a[i] >= 0 && d[j - 1][m - a[i]] != -1) {
						d[j][m] = Math.max(d[j][m], d[j - 1][m - a[i]] + b[i]);
					}
				}
			}
		}
		int maxa = 0;
		for (int i = sum; i <= max; ++i) {
			maxa = Math.max(d[k][i], maxa);
		}
		pw.println(k + " " + (sum - maxa));
		pw.close();
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