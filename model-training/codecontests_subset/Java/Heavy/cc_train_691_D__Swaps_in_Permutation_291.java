import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swapsInPermutation {

	static ArrayList<Integer> graph[];
	static byte vis[];
	static int[] p;

	static void buildGraph(int N) {
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<Integer>();
		vis = new byte[N];
	}

	static ArrayList<Integer> bfs(int u) {
		vis[u] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		q.add(u);
		while (!q.isEmpty()) {
			int curr = q.remove();
			ret.add(curr);
			for (int v : graph[curr]) {
				if (vis[v] != 1) {
					vis[v] = 1;
					q.add(v);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		p = new int[n];
		buildGraph(n + 1);
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int k = sc.nextInt() - 1;
			graph[u].add(k);
			graph[k].add(u);
		}
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] != 1) {
				ArrayList<Integer> CCpos = bfs(i);
				int size1 = CCpos.size();
				int[] v = new int[size1];
				for (int j = 0; j < size1; j++)
					v[j] = p[CCpos.get(j)];
				Collections.sort(CCpos);
				Arrays.sort(v);
				for (int j = 0; j < size1; j++)
					ans[CCpos.get(j)] = v[size1 - j - 1];
			}
		}
		for (int i = 0; i < ans.length; i++)
			sb.append(ans[i] + " ");
		System.out.println(sb);

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
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
