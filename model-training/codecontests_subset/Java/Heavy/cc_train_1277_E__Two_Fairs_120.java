

import java.util.*;
import java.io.*;
import java.text.*;

public class E1277 {
	static ArrayList<Integer>[] adjList;

	static int n;
	static boolean[] vis;

	public static void dfs(int u, int v) {
		vis[u] = true;
		for (int x : adjList[u]) {
			if (x != v && !vis[x]) {
				dfs(x, v);
			}
		}
	}

	public static int cnt(int a, int b) {
		vis = new boolean[n];
		int cnt = 0;
		dfs(a,b);
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i])
				cnt++;
		}
//		System.out.println(Arrays.toString(vis));
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			int m = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList = new ArrayList[n];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Integer>();
			while (m-- > 0) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			int x = cnt(a-1, b-1)-1;
			int y = cnt(b-1, a-1)-1;
			pw.println(1l*x*y);
		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
