import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class DilworthTheorem {
	static Scanner in = new Scanner();
	static PrintWriter out = new PrintWriter(System.out);
	static HashSet<Integer> adj[];
	static int n, m, count;
	static boolean vis[];
	static TreeSet<Integer> set;

	public static void main(String[] args) throws Exception {
		n = in.nextInt();
		m = in.nextInt();
		set = new TreeSet<>();
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			set.add(i);
		}
		adj = new HashSet[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new HashSet<>();
		}
		for (int i = 0; i < m; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adj[u].add(v);
			adj[v].add(u);
		}
		ArrayList<Integer> ans = new ArrayList<>();

		while (!set.isEmpty()) {
			ans.add(dfs(set.pollFirst()));
		}
		out.println(ans.size());
		Collections.sort(ans);
		for (Integer i : ans) {
			out.print(i + " ");
		}
		out.flush();
		out.close();
	}

	static int dfs(int node) {
		ArrayList<Integer> child = new ArrayList<>();
		for (Integer i : set) {
			if (!adj[node].contains(i)) {
				child.add(i);
			}
		}
		for (Integer i : child) {
			set.remove(i);
		}
		int ret = 1;
		for (Integer i : child) {
			ret += dfs(i);
		}
		return ret;
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public Scanner(FileReader fileReader) throws FileNotFoundException {
			br = new BufferedReader(fileReader);
		}

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}