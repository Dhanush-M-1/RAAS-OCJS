
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
	
	ArrayList<Integer> g[];
	int color[];
	int di[];
	
	int getRoot(int v) {
		return (v == color[v] ? v : (color[v] = getRoot(color[v])));
	}
	
	void merge(int v, int u) {
		v = getRoot(v);
		u = getRoot(u);
		if (new Random().nextInt(1000) < 500)
			color[v] = u;
		else
			color[u] = v;
	}
	
	int[] go(int v, int pr) {
		int res[] = new int[2];
		res[0] = -1;
		res[1] = v;
		for (int i = 0; i < g[v].size(); i++) {
			if (g[v].get(i) != pr) {
				int tmp[] = go(g[v].get(i), v);
				if (res[0] < tmp[0]) {
					res[0] = tmp[0];
					res[1] = tmp[1];
				}
			}
		}
		res[0]++;
		return res;
	}
	
	int go2(int v, int pr) {
		int mx = -1;
		for (int i = 0; i < g[v].size(); i++) {
			if (g[v].get(i) != pr) {
				mx = max(mx, go2(g[v].get(i), v));
			}
		}
		mx++;
		return mx;
	}
	
	void solve() throws Exception {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		g = new ArrayList[n];
		color = new int[n];
		di = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = i;
			g[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int v = sc.nextInt() - 1;
			int u = sc.nextInt() - 1;
			g[v].add(u);
			g[u].add(v);
			merge(v, u);
		}
		boolean used[] = new boolean[n];
		int res[][] = new int[n][];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int v = getRoot(i);
			if (!used[v]) {
				res[cnt++] = go(v, -1);
				used[v] = true;
			}
		}
		for (int i = 0; i < cnt; i++) {
			int v = res[i][1];
			int root = getRoot(v);
			di[root] = go2(v, -1);
		}
		while (q-- > 0) {
			int tp = sc.nextInt();
			if (tp == 1) {
				int v = getRoot(sc.nextInt() - 1);
				out.println(di[v]);
			} else {
				int v = getRoot(sc.nextInt() - 1);
				int u = getRoot(sc.nextInt() - 1);
				if (v != u) {
					int ndi = max(max(di[v], di[u]), (di[v] + 1) / 2 + (di[u] + 1) / 2 + 1);
					merge(v, u);
					v = getRoot(v);
					di[v] = ndi;
				}
			}
		}
	}
	
	BufferedReader in;
	PrintWriter out;
	FastScanner sc;
	
	static Throwable throwable;
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//in = new BufferedReader(new FileReader(".in"));
			//out = new PrintWriter(".out");
			sc = new FastScanner(in);
			solve();
		} catch (Exception e) {
			throwable = e;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread thread = new Thread(null, new Solution(), "", (1 << 26));
		thread.start();
		thread.join();
		thread.run();
		if (Solution.throwable != null)
			throw Solution.throwable;
	}

}

class FastScanner {
	BufferedReader reader;
	StringTokenizer strTok;
	
	public FastScanner(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String nextToken() throws Exception {
		while (strTok == null || !strTok.hasMoreTokens())
			strTok = new StringTokenizer(reader.readLine());
		return strTok.nextToken();
	}
	
	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}
	
	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}
}