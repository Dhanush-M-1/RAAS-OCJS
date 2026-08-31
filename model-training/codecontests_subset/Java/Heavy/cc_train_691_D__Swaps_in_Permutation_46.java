import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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



public class E14D {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;

	static int[] a, d;
	static boolean[] b;
	static ArrayList[] g;
	static Integer[] sor, ind;
	static int l;
	static int n, q;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		n = nextInt();
		q = nextInt();
		a = new int [n];
		b = new boolean [n];
		d = new int [n];
		sor = new Integer [n];
		ind = new Integer [n];
		g = new ArrayList[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
			g[i] = new ArrayList<Integer>();
		}
		int u, v;	
		for (int i = 0; i < q; ++i) {
			u = nextInt() - 1;
			v = nextInt() - 1;
			g[u].add(v);
			g[v].add(u);
		}
		for (int i = 0; i < n; ++i) {
			if (!b[i]) {
				l = 0;
				dfs(i);
				Arrays.sort(ind, 0, l);
				Arrays.sort(sor, 0, l);
				for (int j = 0; j < l; ++j) 
					d[ind[j]] = -sor[j];
			}
		}
		for (int i = 0; i < n; ++i)
			pw.print(d[i] + " ");
		pw.close();
	}
	
	private static void dfs(int i) {
		b[i] = true;
		sor[l] = new Integer(-a[i]);
		ind[l++] = new Integer(i);
		for (int j = 0; j < g[i].size(); ++j) {
			int index = (int) g[i].get(j); 
			if (!b[index]) {
				dfs(index);
			}
		}
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