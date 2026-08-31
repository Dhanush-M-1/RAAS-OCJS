
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//691D
public class SwapsInPermutation {

	static ArrayList<Integer>[] graph;
	static boolean[] vis;

	static ArrayList<Integer> bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		vis[s] = true;
		ArrayList<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			int u = q.poll();
			res.add(u);
			for (int v : graph[u]) {
				if (!vis[v]) {
					vis[v] = true;
					q.add(v);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = sc.nextInt();
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		while (m-- > 0) {
			int u = sc.nextInt(), v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		vis = new boolean[n + 1];
		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				ArrayList<Integer> pos = bfs(i);
				ArrayList<Integer> p = new ArrayList<>();
				for (int j : pos)
					p.add(a[j]);
				Collections.sort(pos);
				Collections.sort(p);
				int nn = pos.size();
				int k = nn - 1;
				for (int j = 0; j < nn; j++) {
					ans[pos.get(j)] = p.get(k--);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans[1]);
		for (int i = 2; i <= n; i++)
			sb.append(" ").append(ans[i]);
		pw.println(sb);
		pw.close();
	}

	static class MyScanner {
		StringTokenizer st;
		BufferedReader br;

		public MyScanner(InputStream s) {
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
